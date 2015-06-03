package ql_obj_alg.check.errors;

import ql_obj_alg.check.types.Type;

public class ConflictingTypeInAssignmentError extends GenError {
	private Type expected;
	private Type found;
	private String varName;
	
	public ConflictingTypeInAssignmentError(Type expected, Type found, String varName){
		this.expected = expected;
		this.found = found;
		this.varName = varName;
	}
	
	@Override
	public int hashCode(){
		return toString().hashCode();
	}
	
	@Override
	public String toString(){
		return "Conflicting types in question "+varName+" assignment, "+ "(" + expected.toString()+", "+found.toString()+").";
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj == null)
			return false;
		
		if(obj instanceof ConflictingTypeInAssignmentError){
			ConflictingTypeInAssignmentError other = (ConflictingTypeInAssignmentError) obj;
			
			if(this.expected == other.expected || (this.expected != null && this.expected.equals(other.expected))){
				if(this.found == other.found || (this.found != null && this.found.equals(other.found))){
					if(this.varName == other.varName || (this.varName != null && this.varName.equals(other.varName)))
						return true;
				}
			}		
			return false;	
		}
		return false;
	}
}
