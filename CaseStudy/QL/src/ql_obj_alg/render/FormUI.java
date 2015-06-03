package ql_obj_alg.render;

import java.util.List;

import ql_obj_alg.eval.IDepsAndEvalE;
import ql_obj_alg.eval.ValueEnvironment;
import ql_obj_alg.syntax.IExpAlg;
import ql_obj_alg.syntax.IFormAlg;

public interface FormUI extends IFormAlg<IDepsAndEvalE,IRender,IRenderForm>{

	IExpAlg<IDepsAndEvalE> expAlg();
	
	@Override
	default IRenderForm form(final String id, final List<IRender> s) {
		return new IRenderForm(){
			@Override
			public void render(final ValueEnvironment valEnv, final Registry registry) {
				final FormFrame frame = new FormFrame(id);
				for(IRender stmt : s){
					stmt.render(frame, valEnv, registry, expAlg().bool(true));
				}
				frame.render();
			}
		};
	}

}

