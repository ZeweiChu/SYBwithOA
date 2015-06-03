package ql_obj_alg.check.types;

public class TString extends Type {

	@Override
	public boolean isComparable(Type t) {
		if(t == null)
			return false;
		return t.isAlphanumeric();
	}

	@Override
	public boolean isOrd() {
		return true;
	}

	@Override
	public boolean isAlphanumeric() {
		return true;
	}


	@Override
	public boolean equals(Object obj){
		if(obj == null)
			return false;
		
		return obj instanceof TString;
	}
	
	@Override
	public int hashCode(){
		return "string".hashCode();
	}

	@Override
	public Type merge(Type t) {
		if(t.isAlphanumeric())
			return t;
		return this;
	}

	@Override
	public String toString() {
		return "string";
	}

	@Override
	public Type merge(TString t) {
		return this;
	}

}
