package ql_obj_alg.render;

import java.util.Observable;
import java.util.Observer;

import ql_obj_alg.eval.IDepsAndEvalE;
import ql_obj_alg.eval.ValueEnvironment;
import ql_obj_alg.eval.values.Value;
import ql_obj_alg.render.widgets.Widget;

public class ValueObserver implements Observer {
	
	final String id;
	final IDepsAndEvalE e;
	final FormFrame frame;
	final Widget widget;
	final ValueEnvironment valEnv;
	private Registry registry;
	
	public ValueObserver(String id, IDepsAndEvalE e, FormFrame frame, Widget widget, ValueEnvironment valEnv, Registry registry){
		this.id = id;
		this.e = e;
		this.frame = frame;
		this.widget = widget;
		this.valEnv = valEnv;
		this.registry = registry;
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		Value val = e.eval(valEnv);
		valEnv.setQuestionValue(id, val);
		widget.setValue(val);
		registry.notifyObservers(id);
		frame.pack();
	}
	
	

}
