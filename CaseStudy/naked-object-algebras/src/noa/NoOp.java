package noa;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class NoOp implements InvocationHandler {
	@SuppressWarnings("unchecked")
	public static <T> T noOp(Class<T> alg) {
		return (T) Proxy.newProxyInstance(alg.getClassLoader(),new Class[]{alg},new NoOp());
	}
	
	private NoOp() {
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		return new Object();
	}
			
}
