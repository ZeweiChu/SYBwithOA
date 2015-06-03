package ql_obj_alg.eval.values;

public class VInteger extends VBase {
	
	private Integer x;

	public VInteger(int x){
		this.x = new Integer(x);
	}
	
	@Override
	public Integer getInteger(){
		return x;
	}

	public Value mul(Value v){
		return v.mul(this);
	}
	public Value mul(VInteger v){
		return new VInteger(v.getInteger() * x);
	}
	
	public Value div(Value v){
		return v.div(this);
	}
	
	public Value div(VInteger v){
		if(x == 0) return new VUndefined();
		return new VInteger(v.getInteger() / x);
	}
	
	public Value add(Value v){
		return v.add(this);
	}
	
	public Value add(VInteger v){
		return new VInteger(v.getInteger() + x);
	}	
	
	public Value min(Value v){
		return v.min(this);
	}
	
	public Value min(VInteger v){
		return new VInteger(v.getInteger() - x);
	}
	
	public Value lt(Value v){
		return v.lt(this);
	}
	
	public Value lt(VInteger v){
		return new VBoolean(v.getInteger() < x);
	}	
	
	public Value leq(Value v){
		return v.leq(this);
	}
	
	public Value leq(VInteger v){
		return new VBoolean(v.getInteger() <= x);
	}		
	
	public Value gt(Value v){
		return v.gt(this);
	}
	
	public Value gt(VInteger v){
		return new VBoolean(v.getInteger() > x);
	}	
	
	
	public Value geq(Value v){
		return v.geq(this);
	}
	
	public Value geq(VInteger v){
		return new VBoolean(v.getInteger() >= x);
	}	
	
	
	public Value eq(Value v){
		return v.eq(this);
	}
	
	public Value eq(VInteger v){
		return new VBoolean(v.getInteger().equals(x));
	}	
	
	
	public Value neq(Value v){
		return v.neq(this);
	}
	
	public Value neq(VInteger v){
		return new VBoolean(!v.getInteger().equals(x));
	}	
	
	@Override 
	public String toString(){
		return ""+x;
	}
	@Override
	public boolean isUndefined(){
		return false;
	}	
}
