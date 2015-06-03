package _ast;

import ql_obj_alg.syntax.IExpAlg;

public class Add extends BinaryExp {

	public Add(Exp lhs, Exp rhs) {
		super(lhs, rhs);
	}

	@Override
	protected Exp make(Exp lhs, Exp rhs) {
		return new Add(lhs, rhs);
	}

	@Override
	protected <E> E recons2(IExpAlg<E> alg, E lhs, E rhs) {
		return alg.add(lhs, rhs);
	}

}
