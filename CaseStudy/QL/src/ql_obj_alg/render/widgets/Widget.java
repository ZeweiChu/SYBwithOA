package ql_obj_alg.render.widgets;

import java.awt.event.ActionListener;

import ql_obj_alg.check.types.TBoolean;
import ql_obj_alg.check.types.TInteger;
import ql_obj_alg.check.types.TString;
import ql_obj_alg.check.types.Type;
import ql_obj_alg.eval.values.Value;
import ql_obj_alg.render.FormFrame;

public abstract class Widget {
	public abstract void setValue(Value v);

	public abstract Value getValue();

	public abstract String getId();

	public abstract void addComputedQuestionToFrame(FormFrame frame);

	public abstract void addAnswerableQuestionToFrame(FormFrame frame);

	public abstract void setVisible(boolean visible);

	public abstract void addActionListener(ActionListener al);

	public static Widget create(String id, String label, Type type) {
		assert type != null : "Null type for widget creation.";
		if (type.equals(new TInteger())) {
			return new IntegerWidget(id, label);
		} 
		if (type.equals(new TString())) {
			return new StringWidget(id, label);
		}
		if (type.equals(new TBoolean())) {
			return new BooleanWidget(id, label);
		}
		throw new AssertionError("Unsupported type: " + type);
	}
}
