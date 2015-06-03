package _ast;

import java.util.List;

import ql_obj_alg.syntax.IFormAlg;

public interface BuildFormAST extends IFormAlg<Exp, Stmt, Form> {

	@Override
	default Form form(String id, List<Stmt> statements) {
		return new Form(id, statements);
	}

}
