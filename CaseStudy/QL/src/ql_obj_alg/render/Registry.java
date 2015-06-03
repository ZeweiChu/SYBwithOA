package ql_obj_alg.render;

import java.util.HashMap;
import java.util.Map;

import ql_obj_alg.eval.IDepsAndEvalE;
import ql_obj_alg.eval.ValueEnvironment;
import ql_obj_alg.render.widgets.ObservableWidget;
import ql_obj_alg.render.widgets.Widget;

public class Registry {
	private Map<String, ObservableWidget> registry;

	public Registry(){
		registry = new HashMap<String,ObservableWidget>();
	}

	private void initObservable(String name) {
		if (!registry.containsKey(name)) {
			registry.put(name, new ObservableWidget());
		}
	}

	
	public ObservableWidget getObservable(String name) {
		initObservable(name);
		return registry.get(name);
	}

	
	public void notifyObservers(final String id) {
		ObservableWidget obs = this.getObservable(id);
		obs.setChanged();
		obs.notifyObservers();
	}
	
	public void createVisibilityObservers(final String id, final FormFrame frame, ValueEnvironment valEnv,
			final Widget widget, final IDepsAndEvalE condition) {
		for(String dep : condition.deps()){
			this.getObservable(dep).addObserver(new VisibilityObserver(id, frame, widget, valEnv, this, condition));
		}
	}

	public void createValueObservers(final String id, final IDepsAndEvalE e, final FormFrame frame, ValueEnvironment valEnv, final Widget widget) {
		for(String dep : e.deps()){
			this.getObservable(dep).addObserver(new ValueObserver(id, e, frame, widget, valEnv, this));		
		}
	}

}
