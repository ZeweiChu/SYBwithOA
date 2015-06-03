package _ast;

import java.util.Map;
import java.util.Set;

import library.Pair;
import ql_obj_alg.syntax.IExpAlg;
import ql_obj_alg.syntax.IStmtAlg;

public class Unless extends Conditional {
	
	public Unless(Exp cond, Stmt body) {
		super(cond, body);
	}

	@Override
	public Stmt rename(Map<String, String> ren) {
		return new Unless(cond.rename(ren), then.rename(ren));
	}


	@Override
	public <E, S> S recons(IExpAlg<E> expAlg, IStmtAlg<E, S> stmtAlg) {
		return stmtAlg.iff(expAlg.not(cond.recons(expAlg)), then.recons(expAlg, stmtAlg));
	}

	@Override
	public int count() {
		return 1 + cond.count() + then.count();
	}

	@Override
	public Set<Pair<String, String>> controlDeps() {
		return new If(cond, then).controlDeps();
	}
	
	@Override
	public Stmt flatten(Exp guard) {
		return then.flatten(new And(guard, new Not(cond)));
	}

}
