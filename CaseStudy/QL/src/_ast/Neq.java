package _ast;

import ql_obj_alg.syntax.IExpAlg;

public class Neq extends BinaryExp {

	public Neq(Exp lhs, Exp rhs) {
		super(lhs, rhs);
	}

	@Override
	protected Exp make(Exp lhs, Exp rhs) {
		return new Neq(lhs, rhs);
	}

	@Override
	protected <E> E recons2(IExpAlg<E> alg, E lhs, E rhs) {
		return alg.neq(lhs, rhs);
	}

}
