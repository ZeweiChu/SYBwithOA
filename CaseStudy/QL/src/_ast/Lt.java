package _ast;

import ql_obj_alg.syntax.IExpAlg;

public class Lt extends BinaryExp {

	public Lt(Exp lhs, Exp rhs) {
		super(lhs, rhs);
	}

	@Override
	protected Exp make(Exp lhs, Exp rhs) {
		return new Lt(lhs, rhs);
	}

	@Override
	protected <E> E recons2(IExpAlg<E> alg, E lhs, E rhs) {
		return alg.lt(lhs, rhs);
	}

}
