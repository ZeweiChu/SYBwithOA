package noa;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;


@SuppressWarnings("unchecked")
public class Injector<A1, A2, O1, O2> implements InvocationHandler {
	private A1 alg1; // A1<O1, O1> or A1<O1>
	private A2 alg2; // A2<O2, Function<O1, O2>> (producing Function<O1, O2> from O2)

	public static <Alg, A1, A2, O1, O2> Alg make(Class<Alg> alg, A1 alg1, A2 alg2, Class<O1> o1, Class<O2> o2) {
		return (Alg) Proxy.newProxyInstance(alg.getClassLoader(), new Class [] {alg}, new Injector<A1, A2, O1, O2>(alg1, alg2));
	}

	private Injector(A1 alg1, A2 alg2) {
		this.alg1 = alg1;
		this.alg2 = alg2;
	}

	
	@Override
	public Pair<O1,O2> invoke(Object proxy, Method method, Object[] args) throws Throwable {
		O1 x = (O1) method.invoke(alg1, lift(args, p -> p.x));
		Function<O1, O2> f = (Function<O1, O2>)method.invoke(alg2, lift(args, p -> p.y));
		O2 y = f.apply(x);
		return new Pair<O1,O2>(x, y);
	}
	
	private static <O1, O2> Object[] lift(Object[] args, Function<Pair<O1,O2>, Object> select) {
		Object[] lifted = new Object[args.length];
		for (int i = 0; i < args.length; i++) {
			if (args[i] instanceof Pair) {
				lifted[i] = select.apply(((Pair<O1,O2>)args[i]));
			}
			else if (args[i] instanceof List) {
				List<Object> l = new ArrayList<Object>();
				for (Object o: (List<Object>)args[i]) {
					l.add(select.apply(((Pair<O1,O2>)o)));
				}
				lifted[i] = l;
			}
			else {
				lifted[i] = args[i];
			}
		}
		return lifted;
	}
}