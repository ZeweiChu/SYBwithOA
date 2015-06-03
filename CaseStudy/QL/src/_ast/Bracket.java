package _ast;

import java.util.Map;
import java.util.Set;

import ql_obj_alg.syntax.IExpAlg;

public class Bracket extends Exp {

	private Exp exp;

	public Bracket(Exp e) {
		this.exp = e;
	}

	@Override
	public Exp rename(Map<String, String> ren) {
		return new Bracket(exp.rename(ren));
	}

	@Override
	public Set<String> freeVars() {
		return exp.freeVars();
	}

	@Override
	public <E> E recons(IExpAlg<E> alg) {
		return alg.bracket(exp.recons(alg));
	}
	
	@Override
	public int count() {
		return 1 + exp.count();
	}

}
