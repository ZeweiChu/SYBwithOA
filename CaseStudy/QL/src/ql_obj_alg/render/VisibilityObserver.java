package ql_obj_alg.render;

import java.util.Observable;
import java.util.Observer;

import ql_obj_alg.eval.IDepsAndEvalE;
import ql_obj_alg.eval.ValueEnvironment;
import ql_obj_alg.eval.values.VUndefined;
import ql_obj_alg.render.widgets.Widget;

public class VisibilityObserver implements Observer {

	final String id;
	final FormFrame frame;
	final Widget widget;
	final ValueEnvironment valEnv;
	final IDepsAndEvalE condition;
	private Registry registry;
	
	public VisibilityObserver(String id, FormFrame frame, Widget widget, ValueEnvironment valEnv, Registry reg, IDepsAndEvalE condition){
		this.id = id;
		this.frame = frame;
		this.widget = widget;
		this.valEnv = valEnv;
		this.registry = reg;
		this.condition = condition;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		boolean visible = condition.eval(valEnv).getBoolean();
		if(!visible){
			valEnv.setQuestionValue(id, new VUndefined());
			widget.setValue(new VUndefined());
		}
		widget.setVisible(visible);
		registry.notifyObservers(id);
		frame.pack();
	}
}
