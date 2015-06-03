package ql_obj_alg.eval.values;

public class VString extends VBase {

	private String s;

	public VString(String s){
		this.s = s;
	}
	
	public String getString(){
		return s;
	}

	public Value lt(Value v){
		return v.lt(this);
	}
	
	public Value lt(VString v){
		return new VBoolean(v.getString().compareTo(s) == -1);
	}	
	
	public Value leq(Value v){
		return v.leq(this);
	}
	
	public Value leq(VString v){
		int compare = v.getString().compareTo(s);
		return new VBoolean(compare == -1 || compare == 0);
	}	

	public Value gt(Value v){
		return v.gt(this);
	}
	
	public Value gt(VString v){
		return new VBoolean(v.getString().compareTo(s) == 1);
	}	
	
	public Value geq(Value v){
		return v.geq(this);
	}
	
	public Value geq(VString v){
		int compare = v.getString().compareTo(s);
		return new VBoolean(compare == 0 || compare == 1);
	}
	
	public Value eq(Value v){
		return v.eq(this);
	}
	
	public Value eq(VString v){
		return new VBoolean(v.getString().equals(s));
	}		
	
	public Value neq(Value v){
		return v.neq(this);
	}
	
	public Value neq(VString v){
		return new VBoolean(!v.getString().equals(s));
	}	
	
	@Override 
	public String toString(){
		return s;
	}
	
	@Override
	public boolean isUndefined(){
		return false;
	}
}
