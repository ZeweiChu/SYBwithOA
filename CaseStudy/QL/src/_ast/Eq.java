package _ast;

import ql_obj_alg.syntax.IExpAlg;

public class Eq extends BinaryExp {

	public Eq(Exp lhs, Exp rhs) {
		super(lhs, rhs);
	}

	@Override
	protected Exp make(Exp lhs, Exp rhs) {
		return new Eq(lhs, rhs);
	}
	
	@Override
	protected <E> E recons2(IExpAlg<E> alg, E lhs, E rhs) {
		return alg.eq(lhs, rhs);
	}


}
