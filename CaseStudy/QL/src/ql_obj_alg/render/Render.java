package ql_obj_alg.render;

import ql_obj_alg.eval.ExprEvaluator;
import ql_obj_alg.eval.IDepsAndEvalE;
import ql_obj_alg.syntax.IExpAlg;

public class Render implements StmtUI, FormUI, ExprEvaluator {
	@Override
	public IExpAlg<IDepsAndEvalE> expAlg() {
		return this;
	}

}
