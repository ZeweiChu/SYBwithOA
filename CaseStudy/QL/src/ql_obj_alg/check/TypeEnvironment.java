package ql_obj_alg.check;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import ql_obj_alg.check.types.Type;

public class TypeEnvironment {

	private Map<String,Type> typeEnvironment;
	private Set<String>	labels;
	
	public TypeEnvironment(){
		typeEnvironment = new HashMap<String,Type>();
		labels = new HashSet<String>();
	}
	public void define(String varName, Type type){
		assert !isDefined(varName) : "Variable already defined.";
		typeEnvironment.put(varName, type);
	}
	
	public boolean isDefined(String varName){
		return typeEnvironment.containsKey(varName);
	}
	
	public Type getType(String varName){
		return typeEnvironment.get(varName);
	}
	
	public boolean containsLabel(String label){
		return labels.contains(label);
	}
	
	public void addLabel(String label){
		labels.add(label);
	}
	
}
