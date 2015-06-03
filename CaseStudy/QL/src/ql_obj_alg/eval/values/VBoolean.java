package ql_obj_alg.eval.values;

public class VBoolean extends VBase {

	private Boolean b;

	public VBoolean(boolean b){
		this.b = new Boolean(b);
	}
	@Override	
	public Boolean getBoolean(){
		return b;
	}
	
	public Value eq(Value v){
		return v.eq(this);
	}
	
	public Value eq(VBoolean v){
		return new VBoolean(v.getBoolean().equals(b));
	}

	public Value neq(Value v){
		return v.neq(this);
	}
	
	public Value not(){
		return new VBoolean(!b);
	}
	
	public Value neq(VBoolean v){
		return new VBoolean(b != v.getBoolean());
	}
	
	public Value and(Value v){
		return v.and(this);
	}
	
	public Value and(VBoolean v){
		return new VBoolean(b && v.getBoolean());
	}
	
	public Value or(Value v){
		return v.or(this);
	}
	
	public Value or(VBoolean v){
		return new VBoolean(b || v.getBoolean());
	}
	
	public Value or(VUndefined v){
		return this;
	}
	
	@Override 
	public String toString(){
		return ""+b;
	}
	@Override
	public boolean isUndefined(){
		return false;
	}
}
