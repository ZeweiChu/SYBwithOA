package ql_obj_alg.render.widgets;

import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

import ql_obj_alg.eval.values.VString;
import ql_obj_alg.eval.values.VUndefined;
import ql_obj_alg.eval.values.Value;
import ql_obj_alg.render.FormFrame;
import ql_obj_alg.render.widgets.Widget;

public class StringWidget extends Widget{

	String id;
	JLabel label;
	JTextField text;
	
	public StringWidget(String id, String label){
		this.id = id;
		
		this.text = new JTextField();
		this.text.setColumns(15);
		
		this.label = new JLabel(label);
		this.label.setLabelFor(this.text);
	}
	
	public boolean isAnswerable(){
		return text.isEnabled();
	}
	
	@Override
	public Value getValue(){
		if(isUndefined()){
			return new VUndefined();
		}
		else
			return new VString(text.getText());
	}
	
	private boolean isUndefined() {
		return text.getText() == null || text.getText().equals("");
	}

	@Override
	public void setVisible(boolean visible){
		text.setVisible(visible);
		label.setVisible(visible);
	}

	@Override
	public void addComputedQuestionToFrame(FormFrame frame) {
		text.setEnabled(false);
		frame.addLabel(label);
		frame.addField(text);
	}
	
	@Override
	public void addAnswerableQuestionToFrame(FormFrame frame) {
		text.setEnabled(true);
		frame.addLabel(label);
		frame.addField(text);
	}

	@Override
	public String getId() {
		return id;
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj == null)
			return false;
		
		if(obj instanceof StringWidget)
			return equals((StringWidget) obj);
		return false;
	}
	
	@Override
	public int hashCode(){
		return id.hashCode();
	}


	@Override
	public void setValue(Value v) {
		if(!v.isUndefined()){
			text.setText(v.getString());
		}else{
			text.setText("");
		}
	}

	@Override
	public void addActionListener(ActionListener al) {
		text.addActionListener(al);
	}
	
}
