package ql_obj_alg.render;

import ql_obj_alg.eval.IDepsAndEvalE;
import ql_obj_alg.eval.ValueEnvironment;

public interface IRender {
	void render(FormFrame frame, ValueEnvironment valEnv, Registry registry, IDepsAndEvalE condition);
}
