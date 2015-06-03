package ql_obj_alg.check.errors;

import ql_obj_alg.check.types.Type;

public class UnexpectedTypeError extends GenError {
	private Type expected;
	private Type found;
	private String exp;
	
	public UnexpectedTypeError(Type expected, Type found, String exp){
		this.expected = expected;
		this.found = found;
		this.exp = exp;
	}
	
	@Override
	public int hashCode(){
		return toString().hashCode();
	}
	
	@Override
	public String toString(){
		return "Unexpected type in "+exp+", "+expected.toString()+", "+found.toString()+".";
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj == null)
			return false;
		
		if(obj instanceof UnexpectedTypeError){
			UnexpectedTypeError error = (UnexpectedTypeError) obj;
			
			if(this.expected == error.expected || (this.expected != null && this.expected.equals(error.expected))){
				if(this.found == error.found || (this.found != null && this.found.equals(error.found))){
					if(this.exp == error.exp || (this.exp != null && this.exp.equals(error.exp)))
						return true;
				}
			}		
			return false;	
		}
		return false;
	}
	
	public Type getExpected(){
		return this.expected;
	}
	
	public Type getFound(){
		return this.found;
	}
	
	public String getExp(){
		return this.exp;
	}
}
