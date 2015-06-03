package noa;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

public class Union {


	@SuppressWarnings("unchecked")
	public static <T> T union(Class<T> algInterface, Object ...algs) {
		return (T) Proxy.newProxyInstance(algInterface.getClassLoader(), new Class<?>[] { algInterface },
				(x, m, args) -> {
					for (Object alg: algs) {
						try {
							return m.invoke(alg, args);
						}
						catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
							continue;
						}
					}
					throw new UnsupportedOperationException("method was not found in algebras: " + m.getName() + "/" + m.getParameterCount());			
				});
	}

	
}
