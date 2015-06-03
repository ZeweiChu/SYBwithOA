package ql_obj_alg.eval;

import java.util.HashMap;
import java.util.Map;

import ql_obj_alg.eval.values.Value;

public class ValueEnvironment {

	private Map<String,Value> questions;
	
	public ValueEnvironment(){
		questions = new HashMap<String,Value>();
	}
	
	public Value getQuestionValue(String id){
		return questions.get(id);
	}

	public void setQuestionValue(String id, Value v){
		questions.put(id,v);
	}	
	
	
}

