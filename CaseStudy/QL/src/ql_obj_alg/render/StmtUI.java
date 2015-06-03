package ql_obj_alg.render;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import ql_obj_alg.check.types.Type;
import ql_obj_alg.eval.IDepsAndEvalE;
import ql_obj_alg.eval.ValueEnvironment;
import ql_obj_alg.eval.values.VUndefined;
import ql_obj_alg.render.widgets.Widget;
import ql_obj_alg.syntax.IExpAlg;
import ql_obj_alg.syntax.IStmtAlg;

public interface StmtUI extends IStmtAlg<IDepsAndEvalE,IRender> {

	IExpAlg<IDepsAndEvalE> expAlg();

	@Override
	default IRender block(List<IRender> stats) {
		return new IRender(){
			@Override
			public void render(final FormFrame frame,final ValueEnvironment valEnv, final Registry registry, IDepsAndEvalE condition) {
				for(IRender stmt : stats){
					stmt.render(frame,valEnv,registry, condition);
				}
			}
		};
	}
	
	@Override
	default IRender iff(final IDepsAndEvalE cond, IRender then) {
		return (frame, valEnv, registry, condition) -> then.render(frame,valEnv,registry, expAlg().and(condition,cond));
	}

	@Override
	default IRender iffelse(final IDepsAndEvalE cond, IRender then, IRender els) {
		return new IRender(){
			@Override
			public void render(final FormFrame frame, final ValueEnvironment valEnv, final Registry registry, IDepsAndEvalE condition) {
					then.render(frame,valEnv,registry, expAlg().and(cond,condition));
					els.render(frame,valEnv,registry, expAlg().and(expAlg().not(cond),condition));
			}
		};
	}

	@Override
	default IRender question(final String id, final String label, final Type type) {
		return new IRender(){
			@Override
			public void render(final FormFrame frame, final ValueEnvironment valEnv, final Registry registry,  
					 final IDepsAndEvalE condition) {
				valEnv.setQuestionValue(id, new VUndefined());
				final Widget widget = Widget.create(id,label,type);
				widget.setVisible(condition.eval(valEnv).getBoolean());
				widget.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent arg0) {
						valEnv.setQuestionValue(id, widget.getValue());
						registry.notifyObservers(id);
						frame.pack();
					}
				});
				widget.addAnswerableQuestionToFrame(frame);				
				registry.createVisibilityObservers(id, frame, valEnv, widget, condition);
			}
		};
	}

	@Override
	default IRender question(final String id, final String label, final Type type, final IDepsAndEvalE exp) {
		return new IRender(){

			@Override
			public void render(final FormFrame frame, final ValueEnvironment valEnv, final Registry registry, 
					final IDepsAndEvalE condition) {
				valEnv.setQuestionValue(id, new VUndefined());				
				final Widget widget = Widget.create(id,label,type);
				widget.setVisible(condition.eval(valEnv).getBoolean());
				widget.setValue(exp.eval(valEnv));
				widget.addComputedQuestionToFrame(frame);
				registry.createValueObservers(id, exp, frame, valEnv, widget);
				registry.createVisibilityObservers(id, frame, valEnv, widget, condition);			

			}
		};
	}

}
