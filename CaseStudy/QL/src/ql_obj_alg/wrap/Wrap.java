package ql_obj_alg.wrap;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

import noa.Builder;

public class Wrap {

	@SuppressWarnings("unchecked")
	public static <T> T builderBuilder(Class<T> alg, Class<?> operation) {
		return (T) Proxy.newProxyInstance(alg.getClassLoader(),new Class[]{alg}, new Handler(operation));
	}
			
	private static class Handler implements InvocationHandler {
		
		private Class<?> operation;

		public Handler(Class<?> operation) {
			this.operation = operation;
		}
		
		@Override
		public Wrap invoke(Object proxy, Method method, Object[] args) {
			return new Wrap(method, args, operation);
		} 
	}

	private Method method;
	private Object[] args;
	private Class<?> operation;

	
	private Wrap(Method method, Object[] args, Class<?> operation){
		this.method = method;
		this.args = args;		
		this.operation = operation;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T build(Object ...algebras){
		Object[] builtArgs = new Object[args.length];
		for (int i = 0; i < args.length; i++) {
			builtArgs[i] = buildArgument(args[i], algebras);
		}
		return (T) invokeOnAlgebra(algebras, builtArgs);
	}

	private static Object buildArgument(Object arg, Object ...algebras) {
		if (arg instanceof List<?>){
			return buildList((List<?>) arg, algebras);
		}
		if (arg instanceof Builder){
			return buildObject((Builder) arg, algebras);
		}
		return arg;
	}

	private static Object buildObject(Builder arg, Object[] algebras) {
		return arg.build(algebras);
	}

	private static List<Object> buildList(List<?> argList, Object[] algebras) {
		List<Object> args = new ArrayList<Object>();
		for (Object arg : argList){
			if (arg instanceof Builder){
				args.add(buildObject((Builder)arg, algebras));
			}
			else {
				args.add(arg);
			}
		}
		return args;
	}

	private Object invokeOnAlgebra(Object[] algebras, Object[] args) {
		for (Object factory : algebras){
			if (hasMethod(factory)) {
				try {
					return method.invoke(factory, args);
				} 
				catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					throw new RuntimeException(e);
				}
			}
		}
		throw new UnsupportedOperationException("method was not found in algebras: " + method.getName() + "/" + method.getParameterCount());
	}

	private boolean hasMethod(Object factory) {
		Method[] methods = factory.getClass().getMethods();
		for (Method m : methods)  {
			// TODO: check argument types too?
			if (m.getName().equals(method.getName()) && m.getParameterCount() == method.getParameterCount()) {
				return true;
			}
		}
		return false;
	}
}
