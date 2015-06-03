package _ast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import library.Pair;
import ql_obj_alg.syntax.IExpAlg;
import ql_obj_alg.syntax.IStmtAlg;

public class If extends Conditional {

	public If(Exp cond, Stmt statements) {
		super(cond, statements);
	}

	@Override
	public Stmt rename(Map<String, String> ren) {
		return new If(cond.rename(ren), then.rename(ren));
	}

	@Override
	public <E, S> S recons(IExpAlg<E> expAlg, IStmtAlg<E, S> stmtAlg) {
		return stmtAlg.iff(cond.recons(expAlg), then.recons(expAlg, stmtAlg));
	}

	@Override
	public int count() {
		return 1 + cond.count() + then.count();
	}

	@Override
	public Set<Pair<String, String>> controlDeps() {
		return new IfElse(cond, then, new Block(Collections.emptyList())).controlDeps();
	}

	@Override
	public Stmt flatten(Exp guard) {
		return new Block(Arrays.asList(then.flatten(new And(guard, cond))));
	}
	

}
