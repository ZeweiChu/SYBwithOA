package _ast;

import java.util.Map;

import _ast.util.Rename;
import ql_obj_alg.check.types.Type;
import ql_obj_alg.syntax.IExpAlg;
import ql_obj_alg.syntax.IStmtAlg;

public class ComputedQuestion extends Question {

	private final Exp exp;

	public ComputedQuestion(String id, String label, Type type, Exp exp) {
		super(id, label, type);
		this.exp = exp;
	}

	@Override
	public Stmt rename(Map<String, String> ren) {
		return new ComputedQuestion(Rename.rename(ren, id), label, type, exp.rename(ren));
	}

	@Override
	public <E, S> S recons(IExpAlg<E> expAlg, IStmtAlg<E, S> stmtAlg) {
		return stmtAlg.question(id, label, type, exp.recons(expAlg));
	}

	@Override
	public int count() {
		return super.count() + exp.count();
	}
}
