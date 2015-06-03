package _ast;

import ql_obj_alg.syntax.IExpAlg;

public class Str extends Const {

	private String value;

	public Str(String s) {
		this.value = s;
	}

	@Override
	public <E> E recons(IExpAlg<E> alg) {
		return alg.string(value);
	}

}
