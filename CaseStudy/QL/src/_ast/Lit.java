package _ast;

import ql_obj_alg.syntax.IExpAlg;

public class Lit extends Const {

	private int value;

	public Lit(int x) {
		this.value = x;
	}

	@Override
	public <E> E recons(IExpAlg<E> alg) {
		return alg.lit(value);
	}

}
