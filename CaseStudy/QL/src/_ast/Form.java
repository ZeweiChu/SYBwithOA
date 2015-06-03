package _ast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import library.Pair;
import ql_obj_alg.check.types.Type;
import ql_obj_alg.syntax.IExpAlg;
import ql_obj_alg.syntax.IFormAlg;
import ql_obj_alg.syntax.IStmtAlg;

public class Form {

	private final String id;
	private final List<Stmt> body;

	public Form(String id, List<Stmt> statements) {
		this.id = id;
		this.body = statements;
	}

	public Form rename(Map<String, String> ren) {
		List<Stmt> newBody = new ArrayList<>();
		for (Stmt s: body) {
			newBody.add(s.rename(ren));
		}
		return new Form(id, newBody);
	}
	
	public Set<Pair<String,String>> controlDeps() {
		return Stmt.depMonoid.fold(body.stream().map((x) -> x.controlDeps()).collect(Collectors.toList()));
	}
	
	public Map<String,Type> typeEnv() {
		Map<String,Type> tenv = Stmt.typeEnvMonoid.empty(); 
		for (Stmt s: body) {
			tenv = Stmt.typeEnvMonoid.join(tenv, s.typeEnv());
		}
		return tenv;
	}
	
	public <E, S, F> F recons(IExpAlg<E> expAlg, IStmtAlg<E, S> stmtAlg, IFormAlg<E, S, F> formAlg) {
		List<S> stats = new ArrayList<>();
		for (Stmt s: body) {
			stats.add(s.recons(expAlg, stmtAlg));
		}
		return formAlg.form(id, stats);
	}
	
	public int count() {
		int count = 1;
		for (Stmt s: body) {
			count += s.count();
		}
		return count;
	}
	
	public Form flatten(Exp guard) {
		List<Stmt> newBody = new ArrayList<>();
		for (Stmt s: body) {
			newBody.add(s.flatten(guard));
		}
		return new Form(id, newBody);
	}
	
}
