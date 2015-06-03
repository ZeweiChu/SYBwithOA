package _syb.trafo;

import transform.IExpAlgTransform;
import transform.IStmtAlgTransform;
import transform.IUnlessAlgTransform;

public interface DesugarUnless<E, S> extends IUnlessAlgTransform<E, S>, IStmtAlgTransform<E, S>, IExpAlgTransform<E> {
	@Override 
	default S unless(E cond, S body) {
		return iff(not(cond), body);
	}
}
