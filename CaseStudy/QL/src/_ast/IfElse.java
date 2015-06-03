package _ast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import library.Pair;
import ql_obj_alg.check.types.Type;
import ql_obj_alg.syntax.IExpAlg;
import ql_obj_alg.syntax.IStmtAlg;

public class IfElse extends Conditional {

	private final Stmt els;

	public IfElse(Exp cond, Stmt statementsIf, Stmt statementsElse) {
		super(cond, statementsIf);
		this.els = statementsElse;
	}

	@Override
	public Stmt rename(Map<String, String> ren) {
		return new IfElse(cond.rename(ren), then.rename(ren), els.rename(ren));
	}

	@Override
	public Map<String, Type> typeEnv() {
		return typeEnvMonoid.join(els.typeEnv(), super.typeEnv());
	}

	@Override
	public Set<Pair<String, String>> controlDeps() {
		Set<Pair<String, String>> s1 = then.controlDeps();
		Set<Pair<String, String>> s2 = els.controlDeps();
		
		Set<Pair<String,String>> result = new HashSet<>();
		for (Set<Pair<String,String>> s: Arrays.asList(s1, s2)) {
			for (Pair<String,String> x: s) {
				if (x.b().equals("")) {
					for (String c: cond.freeVars()) {
						result.add(new Pair<>(x.a(), c));
					}
				}
			}
		}
		return depMonoid.join(s1, depMonoid.join(s2, result));
	}
	
	@Override
	public <E, S> S recons(IExpAlg<E> expAlg, IStmtAlg<E, S> stmtAlg) {
		return stmtAlg.iffelse(cond.recons(expAlg), then.recons(expAlg, stmtAlg), els.recons(expAlg, stmtAlg));
	}

	@Override
	public int count() {
		return 1 + cond.count() + then.count() + els.count();
	}
	
	@Override
	public Stmt flatten(Exp guard) {
		return new Block(Arrays.asList(then.flatten(new And(guard, cond)), els.flatten(new And(guard, new Not(cond)))));
	}
	
}
