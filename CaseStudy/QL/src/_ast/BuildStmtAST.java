package _ast;

import java.util.List;

import ql_obj_alg.check.types.Type;
import ql_obj_alg.syntax.IStmtAlg;

public interface BuildStmtAST extends IStmtAlg<Exp, Stmt> {
	
	@Override
	default Stmt block(List<Stmt> stats) {
		return new Block(stats);
	}
	
	@Override
	default Stmt iff(Exp cond, Stmt statements) {
		return new If(cond, statements);
	}

	@Override
	default Stmt iffelse(Exp cond, Stmt statementsIf, Stmt statementsElse) {
		return new IfElse(cond, statementsIf, statementsElse);
	}

	@Override
	default Stmt question(String id, String label, Type type) {
		return new AnswerableQuestion(id, label, type);
	}

	@Override
	default Stmt question(String id, String label, Type type, Exp exp) {
		return new ComputedQuestion(id, label, type, exp);
	}

}
