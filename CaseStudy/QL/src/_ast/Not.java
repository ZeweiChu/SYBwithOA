package _ast;

import java.util.Map;
import java.util.Set;

import ql_obj_alg.syntax.IExpAlg;

public class Not extends Exp {

	private Exp arg;

	public Not(Exp exp) {
		this.arg = exp;
	}

	@Override
	public Exp rename(Map<String, String> ren) {
		return new Not(arg.rename(ren));
	}

	@Override
	public Set<String> freeVars() {
		return arg.freeVars();
	}

	@Override
	public <E> E recons(IExpAlg<E> alg) {
		return alg.not(arg.recons(alg));
	}
	
	@Override
	public int count() {
		return 1 + arg.count();
	}

}
