package ql_obj_alg.eval.values;

public class VUndefined extends VBase{

	@Override 
	public Boolean getBoolean(){
		return new Boolean(false);
	}
	@Override
	public Value div(Value v) {
		return this;
	}

	@Override
	public Value div(VInteger v) {
		return this;
	}

	@Override
	public Value div(VBoolean v) {
		return this;
	}

	@Override
	public Value div(VString v) {
		return this;
	}

	@Override
	public Value div(VUndefined v) {
		return this;
	}

	@Override
	public Value add(Value v) {
		return this;
	}

	@Override
	public Value add(VInteger v) {
		return this;
	}

	@Override
	public Value add(VBoolean v) {
		return this;
	}

	@Override
	public Value add(VString v) {
		return this;
	}

	@Override
	public Value add(VUndefined v) {
		return this;
	}


	@Override
	public Value min(Value v) {
		return this;
	}

	@Override
	public Value min(VInteger v) {
		return this;
	}

	@Override
	public Value min(VBoolean v) {
		return this;
	}

	@Override
	public Value min(VString v) {
		return this;
	}

	@Override
	public Value min(VUndefined v) {
		return this;
	}


	@Override
	public Value lt(Value v) {
		return this;
	}

	@Override
	public Value lt(VInteger v) {
		return this;
	}

	@Override
	public Value lt(VBoolean v) {
		return this;
	}

	@Override
	public Value lt(VString v) {
		return this;
	}

	@Override
	public Value lt(VUndefined v) {
		return this;
	}

	@Override
	public Value leq(Value v) {
		return this;
	}

	@Override
	public Value leq(VInteger v) {
		return this;
	}

	@Override
	public Value leq(VBoolean v) {
		return this;
	}

	@Override
	public Value leq(VString v) {
		return this;
	}

	@Override
	public Value leq(VUndefined v) {
		return this;
	}

	@Override
	public Value gt(Value v) {
		return this;
	}

	@Override
	public Value gt(VInteger v) {
		return this;
	}

	@Override
	public Value gt(VBoolean v) {
		return this;
	}

	@Override
	public Value gt(VString v) {
		return this;
	}

	@Override
	public Value gt(VUndefined v) {
		return this;
	}

	@Override
	public Value geq(Value v) {
		return this;
	}

	@Override
	public Value geq(VInteger v) {
		return this;
	}

	@Override
	public Value geq(VBoolean v) {
		return this;
	}

	@Override
	public Value geq(VString v) {
		return this;
	}

	@Override
	public Value geq(VUndefined v) {
		return this;
	}

	@Override
	public Value eq(Value v) {
		return this;
	}

	@Override
	public Value eq(VInteger v) {
		return this;
	}

	@Override
	public Value eq(VBoolean v) {
		return this;
	}

	@Override
	public Value eq(VString v) {
		return this;
	}

	@Override
	public Value eq(VUndefined v) {
		return new VBoolean(true);
	}

	@Override
	public Value neq(Value v) {
		return this;
	}

	@Override
	public Value neq(VInteger v) {
		return this;
	}

	@Override
	public Value neq(VBoolean v) {
		return this;
	}

	@Override
	public Value neq(VString v) {
		return this;
	}

	@Override
	public Value neq(VUndefined v) {
		return this;
	}

	@Override
	public Value and(Value v) {
		return this;
	}

	@Override
	public Value and(VInteger v) {
		return this;
	}

	@Override
	public Value and(VBoolean v) {
		return this;
	}

	@Override
	public Value and(VString v) {
		return this;
	}

	@Override
	public Value and(VUndefined v) {
		return this;
	}

	@Override
	public Value or(Value v) {
		return v.or(this);
	}

	@Override
	public Value or(VInteger v) {
		return this;
	}

	@Override
	public Value or(VBoolean v) {
		return v;
	}

	@Override
	public Value or(VString v) {
		return this;
	}

	@Override
	public Value or(VUndefined v) {
		return this;
	}

	@Override
	public Value mul(Value v) {
		return this;
	}

	@Override
	public Value mul(VInteger v) {
		return this;
	}

	@Override
	public Value mul(VBoolean v) {
		return this;
	}

	@Override
	public Value mul(VString v) {
		return this;
	}

	@Override
	public Value mul(VUndefined v) {
		return this;
	}

	@Override
	public Value not() {
		return new VBoolean(true);
	}

}
