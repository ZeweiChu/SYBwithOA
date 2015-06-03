package ql_obj_alg.check.types;

public class TBoolean extends Type {

	@Override
	public boolean isComparable(Type t) {
		if(t == null)
			return false;
		return t.isBoolean();
	}
	
	@Override
	public boolean isBoolean() {
		return true;
	}

	@Override
	public boolean equals(Object obj){
		if(obj == null)
			return false;
		
		return obj instanceof TBoolean;
	}
	
	@Override
	public int hashCode(){
		return "boolean".hashCode();
	}

	@Override
	public Type merge(Type t) {
		return t.merge(this);
	}

	@Override
	public String toString() {
		return "boolean";
	}

	@Override
	public Type merge(TBoolean t) {
		return t;
	}

}
