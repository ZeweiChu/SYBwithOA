package _syb.trafo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import ql_obj_alg.check.types.Type;
import transform.G_IExpAlgTransform;
import transform.G_IFormAlgTransform;
import transform.G_IStmtAlgTransform;

public interface InlineConditions<E, S, F> extends
	G_IFormAlgTransform<E, E, S, F>,
	G_IStmtAlgTransform<E, E, S>, 
	G_IExpAlgTransform<E, E> {

	
	@Override 
	default Function<E, S> iff(Function<E, E> p0, Function<E, S> p1) {
		return (guard) -> {
			return p1.apply(iExpAlg().and(guard, p0.apply(guard)));
		};
	}
	
	@Override 
	default Function<E, S> iffelse(Function<E,E> p0, Function<E, S> p1, Function<E, S> p2) {
		return (guard) -> {
			E conj1 =  iExpAlg().and(guard, p0.apply(guard));
			List<S> ss = new ArrayList<>();
			ss.add(p1.apply(conj1));
			E conj2 = iExpAlg().and(guard, iExpAlg().not(p0.apply(guard)));
			ss.add(p2.apply(conj2));
			return iStmtAlg().block(ss);
		};
	}
	

	@Override
	default Function<E, S> question(String id, String label, Type type) {
		return (guard) -> iStmtAlg().iff(guard, iStmtAlg().question(id, label, type));
	}
	
	@Override
	default Function<E, S> question(String id, String label, Type type, Function<E,E> exp) {
		return (guard) -> iStmtAlg().iff(guard, iStmtAlg().question(id, label, type, exp.apply(guard)));
	}
}
