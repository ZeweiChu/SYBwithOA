package ql_obj_alg.check.errors;

import ql_obj_alg.check.types.Type;

public class ConflictingTypeError extends GenError {
	private Type t1;
	private Type t2;
	private String exp;
	
	public ConflictingTypeError(Type t1, Type t2, String exp){
		this.t1 = t1;
		this.t2 = t2;
		this.exp = exp;
	}
	
	@Override
	public int hashCode(){
		return toString().hashCode();
	}
	
	@Override
	public String toString(){
		return "Conflicting types in "+exp+", ("+t1.toString()+", "+t2.toString()+").";
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj == null)
			return false;
		
		if(obj instanceof ConflictingTypeError){
			ConflictingTypeError other = (ConflictingTypeError) obj;
			
			if(this.t1 == other.t1 || (this.t1 != null && this.t1.equals(other.t1))){
				if(this.t2 == other.t2 || (this.t2 != null && this.t2.equals(other.t2))){
					if(this.exp == other.exp || (this.exp != null && this.exp.equals(other.exp)))
						return true;
				}
			}
			return false;	
		}
		return false;
	}
}
