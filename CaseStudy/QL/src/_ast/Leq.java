package _ast;

import ql_obj_alg.syntax.IExpAlg;

public class Leq extends BinaryExp {

	public Leq(Exp lhs, Exp rhs) {
		super(lhs, rhs);
	}

	@Override
	protected Exp make(Exp lhs, Exp rhs) {
		return new Leq(lhs, rhs);
	}
	
	@Override
	protected <E> E recons2(IExpAlg<E> alg, E lhs, E rhs) {
		return alg.leq(lhs, rhs);
	}


}
