package ql_obj_alg.check.types;

public class TNumber extends Type {

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
	public Type merge(Type t) {
		return t.merge(this);
	}

	@Override
	public Type merge(TInteger t) {
		return t;
	}

	@Override
	public String toString() {
		return "numeric";
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj == null)
			return false;
		
		return obj instanceof TNumber;
	}
}
