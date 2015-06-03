package ql_obj_alg.check.types;

public class TInteger extends TNumber {

	@Override
	public boolean isComparable(Type t) {
		if(t == null)
			return false;
		return t.isNumber();
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
	public boolean equals(Object obj){
		if(obj == null)
			return false;
		
		return obj instanceof TInteger;
	}
	
	@Override
	public int hashCode(){
		return "integer".hashCode();
	}

	@Override
	public Type merge(Type t) {
		return t.merge(this);
	}

	@Override
	public String toString() {
		return "integer";
	}

	@Override
	public Type merge(TInteger t) {
		return this;
	}

}
