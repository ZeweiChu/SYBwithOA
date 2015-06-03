package _ast;

import java.util.Map;

import _ast.util.Rename;
import ql_obj_alg.check.types.Type;
import ql_obj_alg.syntax.IExpAlg;
import ql_obj_alg.syntax.IStmtAlg;

public class AnswerableQuestion extends Question {

	public AnswerableQuestion(String id, String label, Type type) {
		super(id, label, type);
	}

	@Override
	public Stmt rename(Map<String, String> ren) {
		return new AnswerableQuestion(Rename.rename(ren, id), label, type);
	}

	@Override
	public <E, S> S recons(IExpAlg<E> expAlg, IStmtAlg<E, S> stmtAlg) {
		return stmtAlg.question(id, label, type);
	}

}
