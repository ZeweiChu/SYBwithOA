package _ast;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import ql_obj_alg.syntax.IExpAlg;

public abstract class BinaryExp extends Exp {
	protected final Exp lhs;
	protected final Exp rhs;

	public BinaryExp(Exp lhs, Exp rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}

	@Override
	public Exp rename(Map<String, String> ren) {
		return make(lhs.rename(ren), rhs.rename(ren));
	}
	
	protected abstract Exp make(Exp lhs, Exp rhs);
	
	@Override
	public Set<String> freeVars() {
		Set<String> set = new HashSet<>(lhs.freeVars());
		set.addAll(rhs.freeVars());
		return set;
	}
	
	@Override
	public <E> E recons(IExpAlg<E> alg) {
		return recons2(alg, lhs.recons(alg), rhs.recons(alg));
	}
	
	protected abstract <E> E recons2(IExpAlg<E> alg, E lhs, E rhs);
	
	@Override
	public int count() {
		return 1 + lhs.count() + rhs.count();
	}
}
