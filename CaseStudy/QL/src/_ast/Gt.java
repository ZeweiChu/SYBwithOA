package _ast;

import ql_obj_alg.syntax.IExpAlg;

public class Gt extends BinaryExp {

	public Gt(Exp lhs, Exp rhs) {
		super(lhs, rhs);
	}

	@Override
	protected Exp make(Exp lhs, Exp rhs) {
		return new Gt(lhs, rhs);
	}
	
	@Override
	protected <E> E recons2(IExpAlg<E> alg, E lhs, E rhs) {
		return alg.gt(lhs, rhs);
	}


}
