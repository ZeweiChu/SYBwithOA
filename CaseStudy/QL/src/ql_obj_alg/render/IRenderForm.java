package ql_obj_alg.render;

import ql_obj_alg.eval.ValueEnvironment;

public interface IRenderForm {
	void render(ValueEnvironment valEnv, Registry registry);
}
