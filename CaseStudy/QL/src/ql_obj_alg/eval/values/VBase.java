package ql_obj_alg.eval.values;

import ql_obj_alg.eval.values.Value;

public abstract class VBase extends Value {

	@Override
	public Integer getInteger() {
		assert false : "getInteger in" + this.getClass() + " was called";
		return null;
	}

	@Override
	public Boolean getBoolean() {
		assert false : "getBoolean in" + this.getClass() + " was called";
		return null;
	}

	@Override
	public String getString() {
		assert false : "getString in" + this.getClass() + " was called";
		return null;
	}
	@Override
	public Value mul(Value v) {
		assert false : "Wrong types " + this.getClass() + " and " + v.getClass() + " in mul"; return new VUndefined();
	}

	@Override
	public Value mul(VInteger v) {
		assert false : "Wrong types " + this.getClass() + " and " + v.getClass() + " in mul"; return new VUndefined();
	}

	@Override
	public Value mul(VBoolean v) {
		assert false : "Wrong types " + this.getClass() + " and " + v.getClass() + " in mul"; return new VUndefined();
	}

	@Override
	public Value mul(VString v) {
		assert false : "Wrong types " + this.getClass() + " and " + v.getClass() + " in mul"; return new VUndefined();
	}

	@Override
	public Value mul(VUndefined v) {
		assert false : "Wrong types " + this.getClass() + " and " + v.getClass() + " in mul"; return new VUndefined();
	}

	@Override
	public Value div(Value v) {
		assert false : "Wrong types " + this.getClass() + " and " + v.getClass() + " in div"; return new VUndefined();
	}

	@Override
	public Value div(VInteger v) {
		assert false : "Wrong types " + this.getClass() + " and " + v.getClass() + " in div"; return new VUndefined();
	}

	@Override
	public Value div(VBoolean v) {
		assert false : "Wrong types " + this.getClass() + " and " + v.getClass() + " in div"; return new VUndefined();
	}

	@Override
	public Value div(VString v) {
		assert false : "Wrong types " + this.getClass() + " and " + v.getClass() + " in div"; return new VUndefined();
	}

	@Override
	public Value div(VUndefined v) {
		assert false : "Wrong types " + this.getClass() + " and " + v.getClass() + " in div"; return new VUndefined();
	}

	@Override
	public Value add(Value v) {
		assert false : "Wrong types " + this.getClass() + " and " + v.getClass() + " in add"; return new VUndefined();
	}

	@Override
	public Value add(VInteger v) {
		assert false : "Wrong types " + this.getClass() + " and " + v.getClass() + " in add"; return new VUndefined();
	}

	@Override
	public Value add(VBoolean v) {
		assert false : "Wrong types " + this.getClass() + " and " + v.getClass() + " in add"; return new VUndefined();
	}

	@Override
	public Value add(VString v) {
		assert false : "Wrong types " + this.getClass() + " and " + v.getClass() + " in add"; return new VUndefined();
	}

	@Override
	public Value add(VUndefined v) {
		assert false : "Wrong types " + this.getClass() + " and " + v.getClass() + " in add"; return new VUndefined();
	}

	@Override
	public Value min(Value v) {
		assert false : "Wrong types " + this.getClass() + " and " + v.getClass() + " in min"; return new VUndefined();
	}

	@Override
	public Value min(VInteger v) {
		assert false : "Wrong types " + this.getClass() + " and " + v.getClass() + " in min"; return new VUndefined();
	}

	@Override
	public Value min(VBoolean v) {
		assert false : "Wrong types " + this.getClass() + " and " + v.getClass() + " in min"; return new VUndefined();
	}

	@Override
	public Value min(VString v) {
		assert false : "Wrong types " + this.getClass() + " and " + v.getClass() + " in min"; return new VUndefined();
	}

	@Override
	public Value min(VUndefined v) {
		assert false : "Wrong types " + this.getClass() + " and " + v.getClass() + " in min"; return new VUndefined();
	}


	@Override
	public Value lt(Value v) {
		assert false : "Wrong types " + this.getClass() + " and " + v.getClass() + " in lt"; return new VUndefined();
	}

	@Override
	public Value lt(VInteger v) {
		assert false : "Wrong types " + this.getClass() + " and " + v.getClass() + " in lt"; return new VUndefined();
	}

	@Override
	public Value lt(VBoolean v) {
		assert false : "Wrong types " + this.getClass() + " and " + v.getClass() + " in lt"; return new VUndefined();
	}

	@Override
	public Value lt(VString v) {
		assert false : "Wrong types " + this.getClass() + " and " + v.getClass() + " in lt"; return new VUndefined();
	}

	@Override
	public Value lt(VUndefined v) {
		assert false : "Wrong types " + this.getClass() + " and " + v.getClass() + " in lt"; return new VUndefined();
	}

	@Override
	public Value leq(Value v) {
		assert false : "Wrong types " + this.getClass() + " and " + v.getClass() + " in leq"; return new VUndefined();
	}

	@Override
	public Value leq(VInteger v) {
		assert false : "Wrong types " + this.getClass() + " and " + v.getClass() + " in leq"; return new VUndefined();
	}

	@Override
	public Value leq(VBoolean v) {
		assert false : "Wrong types " + this.getClass() + " and " + v.getClass() + " in leq"; return new VUndefined();
	}

	@Override
	public Value leq(VString v) {
		assert false : "Wrong types " + this.getClass() + " and " + v.getClass() + " in leq"; return new VUndefined();
	}

	@Override
	public Value leq(VUndefined v) {
		assert false : "Wrong types " + this.getClass() + " and " + v.getClass() + " in leq"; return new VUndefined();
	}


	@Override
	public Value gt(Value v) {
		assert false : "Wrong types " + this.getClass() + " and " + v.getClass() + " in gt"; return new VUndefined();
	}

	@Override
	public Value gt(VInteger v) {
		assert false : "Wrong types " + this.getClass() + " and " + v.getClass() + " in gt"; return new VUndefined();
	}

	@Override
	public Value gt(VBoolean v) {
		assert false : "Wrong types " + this.getClass() + " and " + v.getClass() + " in gt"; return new VUndefined();
	}

	@Override
	public Value gt(VString v) {
		assert false : "Wrong types " + this.getClass() + " and " + v.getClass() + " in gt"; return new VUndefined();
	}

	@Override
	public Value gt(VUndefined v) {
		assert false : "Wrong types " + this.getClass() + " and " + v.getClass() + " in gt"; return new VUndefined();
	}

	@Override
	public Value geq(Value v) {
		assert false : "Wrong types " + this.getClass() + " and " + v.getClass() + " in geq"; return new VUndefined();
	}

	@Override
	public Value geq(VInteger v) {
		assert false : "Wrong types " + this.getClass() + " and " + v.getClass() + " in geq"; return new VUndefined();
	}

	@Override
	public Value geq(VBoolean v) {
		assert false : "Wrong types " + this.getClass() + " and " + v.getClass() + " in geq"; return new VUndefined();
	}

	@Override
	public Value geq(VString v) {
		assert false : "Wrong types " + this.getClass() + " and " + v.getClass() + " in geq"; return new VUndefined();
	}

	@Override
	public Value geq(VUndefined v) {
		assert false : "Wrong types " + this.getClass() + " and " + v.getClass() + " in geq"; return new VUndefined();
	}

	@Override
	public Value eq(Value v) {
		assert false : "Wrong types " + this.getClass() + " and " + v.getClass() + " in eq"; return new VUndefined();
	}

	@Override
	public Value eq(VInteger v) {
		assert false : "Wrong types " + this.getClass() + " and " + v.getClass() + " in eq"; return new VUndefined();
	}

	@Override
	public Value eq(VBoolean v) {
		assert false : "Wrong types " + this.getClass() + " and " + v.getClass() + " in eq"; return new VUndefined();
	}

	@Override
	public Value eq(VString v) {
		assert false : "Wrong types " + this.getClass() + " and " + v.getClass() + " in eq"; return new VUndefined();
	}

	@Override
	public Value eq(VUndefined v) {
		assert false : "Wrong types " + this.getClass() + " and " + v.getClass() + " in eq"; return new VUndefined();
	}
	
	@Override
	public Value neq(Value v) {
		assert false : "Wrong types " + this.getClass() + " and " + v.getClass() + " in neq"; return new VUndefined();
	}

	@Override
	public Value neq(VInteger v) {
		assert false : "Wrong types " + this.getClass() + " and " + v.getClass() + " in neq"; return new VUndefined();
	}

	@Override
	public Value neq(VBoolean v) {
		assert false : "Wrong types " + this.getClass() + " and " + v.getClass() + " in neq"; return new VUndefined();
	}

	@Override
	public Value neq(VString v) {
		assert false : "Wrong types " + this.getClass() + " and " + v.getClass() + " in neq"; return new VUndefined();
	}

	@Override
	public Value neq(VUndefined v) {
		assert false : "Wrong types " + this.getClass() + " and " + v.getClass() + " in neq"; return new VUndefined();
	}

	@Override
	public Value and(Value v) {
		assert false : "Wrong types " + this.getClass() + " and " + v.getClass() + " in and"; return new VUndefined();
	}

	@Override
	public Value and(VInteger v) {
		assert false : "Wrong types " + this.getClass() + " and " + v.getClass() + " in and"; return new VUndefined();
	}

	@Override
	public Value and(VBoolean v) {
		assert false : "Wrong types " + this.getClass() + " and " + v.getClass() + " in and"; return new VUndefined();
	}

	@Override
	public Value and(VString v) {
		assert false : "Wrong types " + this.getClass() + " and " + v.getClass() + " in and"; return new VUndefined();
	}

	@Override
	public Value and(VUndefined v) {
		assert false : "Wrong types " + this.getClass() + " and " + v.getClass() + " in and"; return new VUndefined();
	}
	
	@Override
	public Value or(Value v) {
		assert false : "Wrong types " + this.getClass() + " and " + v.getClass() + " in or"; return new VUndefined();
	}

	@Override
	public Value or(VInteger v) {
		assert false : "Wrong types " + this.getClass() + " and " + v.getClass() + " in or"; return new VUndefined();
	}

	@Override
	public Value or(VBoolean v) {
		assert false : "Wrong types " + this.getClass() + " and " + v.getClass() + " in or"; return new VUndefined();
	}

	@Override
	public Value or(VString v) {
		assert false : "Wrong types " + this.getClass() + " and " + v.getClass() + " in or"; return new VUndefined();
	}

	@Override
	public Value or(VUndefined v) {
		assert false : "Wrong types " + this.getClass() + " and " + v.getClass() + " in or"; return new VUndefined();
	}


	@Override
	public Value not() {
		assert false : "Wrong type " + this.getClass() + " in not"; return new VUndefined();
	}
	
	@Override 
	public String toString(){
		return "Undefined";
	}

	@Override
	public boolean isUndefined() {
		return true;
	}
}
