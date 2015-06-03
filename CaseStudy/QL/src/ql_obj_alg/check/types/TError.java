package ql_obj_alg.check.types;

public class TError extends Type {

	@Override
	public boolean isComparable(Type t) {
		return true;
	}

	@Override
	public boolean isOrd() {
		return true;
	}

	@Override
	public boolean isNumber() {
		return true;
	}

	@Override
	public boolean isAlphanumeric() {
		return true;
	}

	@Override
	public boolean isBoolean() {
		return true;
	}

	@Override
	public Type merge(Type t) {
		return t.merge(this);
	}

	@Override
	public String toString() {
		return "type error";
	}

	public boolean equals(Object obj){
		if(obj == null)
			return false;
		
		return obj instanceof TError;
	}
}
