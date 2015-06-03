package _ast;

import ql_obj_alg.syntax.IExpAlg;

public class Bool extends Const {

	private boolean value;

	public Bool(boolean b) {
		this.value = b;
	}

	@Override
	public <E> E recons(IExpAlg<E> alg) {
		return alg.bool(value);
	}

}
