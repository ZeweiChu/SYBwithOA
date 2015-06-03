package ql_obj_alg.render.widgets;

import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JLabel;

import ql_obj_alg.eval.values.VBoolean;
import ql_obj_alg.eval.values.VUndefined;
import ql_obj_alg.eval.values.Value;
import ql_obj_alg.render.FormFrame;

public class BooleanWidget extends Widget{

	String id;
	JLabel label;
	JCheckBox checkBox;
	
	public BooleanWidget(String id, String label){
		this.id = id;
		
		this.checkBox = new JCheckBox();	
		this.label = new JLabel(label);
		this.label.setLabelFor(this.checkBox);
	}
	
	public boolean isAnswerable(){
		return checkBox.isEnabled();
	}
	
	@Override
	public Value getValue(){
		if(checkBox.isVisible()){
			return new VBoolean(checkBox.isSelected());
		}
		return new VUndefined();
	}
	
	@Override
	public void setVisible(boolean visible){
		checkBox.setVisible(visible);
		label.setVisible(visible);
	}

	@Override
	public void addComputedQuestionToFrame(FormFrame frame) {
		checkBox.setEnabled(false);
		frame.addLabel(label);
		frame.addField(checkBox);
	}
	
	@Override
	public void addAnswerableQuestionToFrame(FormFrame frame) {
		checkBox.setEnabled(true);
		frame.addLabel(label);
		frame.addField(checkBox);
	}

	@Override
	public String getId() {
		return id;
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj == null)
			return false;
		
		if(obj instanceof BooleanWidget){
			return equals((BooleanWidget) obj);
		}
		return false;
	}

	@Override
	public int hashCode(){
		return id.hashCode();
	}

	@Override
	public void setValue(Value v) {
		checkBox.setSelected(v.getBoolean());
	}

	@Override
	public void addActionListener(ActionListener al) {
		checkBox.addActionListener(al);
	}
}
