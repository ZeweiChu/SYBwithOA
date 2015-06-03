package ql_obj_alg.render.widgets;

import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;

import ql_obj_alg.eval.values.VInteger;
import ql_obj_alg.eval.values.VUndefined;
import ql_obj_alg.eval.values.Value;
import ql_obj_alg.render.FormFrame;

public class IntegerWidget extends Widget{

	String id;
	JLabel label;
	JFormattedTextField field;
	
	public IntegerWidget(String id, String label){
		this.id = id;
		
		this.field = new JFormattedTextField(NumberFormat.getNumberInstance());
		this.field.setColumns(10);
		this.label = new JLabel(label);
		this.label.setLabelFor(this.field);
	}
	
	public boolean isAnswerable(){
		return field.isEnabled();
	}
	
	@Override
	public Value getValue(){
		if(isUndefined()){
			return new VUndefined();
		}
		else
			return new VInteger(Integer.parseInt(field.getText().replace(".", "")));
	}
	
	private boolean isUndefined() {
		return field.getText() == null || field.getText().equals("");
	}

	@Override
	public void setVisible(boolean visible){
		field.setVisible(visible);
		label.setVisible(visible);
	}

	@Override
	public void addComputedQuestionToFrame(FormFrame frame) {
		field.setEnabled(false);
		frame.addLabel(label);
		frame.addField(field);
	}
	
	@Override
	public void addAnswerableQuestionToFrame(FormFrame frame) {
		field.setEnabled(true);
		frame.addLabel(label);
		frame.addField(field);
	}

	@Override
	public String getId() {
		return id;
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj == null)
			return false;
		
		if(obj instanceof IntegerWidget){
			return equals((IntegerWidget) obj);
		}
		return false;
	}
	
	@Override
	public int hashCode(){
		return id.hashCode();
	}
	
	@Override
	public void setValue(Value v) {
		if(!v.isUndefined()){
			field.setValue(v.getInteger());
		}else{
			field.setText("");
		}
	}

	@Override
	public void addActionListener(ActionListener al) {
		field.addActionListener(al);
	}

}
