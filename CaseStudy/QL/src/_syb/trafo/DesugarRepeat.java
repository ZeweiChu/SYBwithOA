package _syb.trafo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import ql_obj_alg.check.types.Type;
import transform.G_IExpAlgTransform;
import transform.G_IFormAlgTransform;
import transform.G_IRepeatAlgTransform;
import transform.G_IStmtAlgTransform;

public interface DesugarRepeat<E, S, F> extends 
	G_IRepeatAlgTransform<String, S>, G_IStmtAlgTransform<String, E, S>, G_IExpAlgTransform<String, E>, 
	G_IFormAlgTransform<String, E, S, F> {

	@Override 
	default Function<String, E> var(String p0) {
		return (n) -> iExpAlg().var(p0 + n);
	}
	
	@Override 
	default Function<String, S> question(String p0, String p1, Type p2) {
		return (n) -> iStmtAlg().question(p0 + n, p1, p2);
	}
	
	@Override 
	default Function<String, S> question(String p0,String p1,Type p2,Function<String, E> p3) {
		return (n) -> iStmtAlg().question(p0 + n, p1, p2, p3.apply(n));
	}
	
	@Override 
	default Function<String, S> repeat(int p0, Function<String, S> p1) {
		return (n) -> {
			List<S> body = new ArrayList<>();
			for (int i = 0; i < p0; i++) {
				body.add(p1.apply(n + "_" + i));
			}
			return iStmtAlg().block(body);
		};
	}
	
}
