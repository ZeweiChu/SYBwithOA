package ql_obj_alg.eval.values;

public abstract class Value {

	public abstract Integer getInteger();
	public abstract Boolean getBoolean();
	public abstract String getString();

	public abstract boolean isUndefined();
	
	public abstract Value mul(Value v);
	public abstract Value mul(VInteger v);
	public abstract Value mul(VBoolean v);
	public abstract Value mul(VString v);
	public abstract Value mul(VUndefined v);
	
	public abstract Value div(Value v);
	public abstract Value div(VInteger v);
	public abstract Value div(VBoolean v);
	public abstract Value div(VString v);
	public abstract Value div(VUndefined v);
	
	public abstract Value add(Value v);
	public abstract Value add(VInteger v);
	public abstract Value add(VBoolean v);
	public abstract Value add(VString v);
	public abstract Value add(VUndefined v);

	public abstract Value min(Value v);
	public abstract Value min(VInteger v);
	public abstract Value min(VBoolean v);
	public abstract Value min(VString v);
	public abstract Value min(VUndefined v);
	
	public abstract Value lt(Value v);
	public abstract Value lt(VInteger v);
	public abstract Value lt(VBoolean v);
	public abstract Value lt(VString v);
	public abstract Value lt(VUndefined v);

	public abstract Value leq(Value v);
	public abstract Value leq(VInteger v);
	public abstract Value leq(VBoolean v);
	public abstract Value leq(VString v);
	public abstract Value leq(VUndefined v);

	public abstract Value gt(Value v);
	public abstract Value gt(VInteger v);
	public abstract Value gt(VBoolean v);
	public abstract Value gt(VString v);
	public abstract Value gt(VUndefined v);

	public abstract Value geq(Value v);
	public abstract Value geq(VInteger v);
	public abstract Value geq(VBoolean v);
	public abstract Value geq(VString v);
	public abstract Value geq(VUndefined v);

	public abstract Value eq(Value v);
	public abstract Value eq(VInteger v);
	public abstract Value eq(VBoolean v);
	public abstract Value eq(VString v);
	public abstract Value eq(VUndefined v);
	
	public abstract Value neq(Value v);
	public abstract Value neq(VInteger v);
	public abstract Value neq(VBoolean v);
	public abstract Value neq(VString v);
	public abstract Value neq(VUndefined v);
	
	public abstract Value and(Value v);
	public abstract Value and(VInteger v);
	public abstract Value and(VBoolean v);
	public abstract Value and(VString v);
	public abstract Value and(VUndefined v);
	
	public abstract Value or(Value v);
	public abstract Value or(VInteger v);
	public abstract Value or(VBoolean v);
	public abstract Value or(VString v);
	public abstract Value or(VUndefined v);
	
	public abstract Value not();
}
