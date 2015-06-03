package _ast;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

import ql_obj_alg.syntax.IExpAlg;
import _ast.util.Rename;

public class Var extends Exp {
	private String name;

	public Var(String name) {
		this.name = name;
	}

	@Override
	public Exp rename(Map<String, String> ren) {
		return new Var(Rename.rename(ren, name));
	}

	@Override
	public Set<String> freeVars() {
		return Collections.singleton(name);
	}

	@Override
	public <E> E recons(IExpAlg<E> alg) {
		return alg.var(name);
	}

	@Override
	public int count() {
		return 1;
	}
	
}
