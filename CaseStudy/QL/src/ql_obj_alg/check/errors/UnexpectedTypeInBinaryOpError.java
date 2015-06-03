package ql_obj_alg.check.errors;

import ql_obj_alg.check.types.Type;

public class UnexpectedTypeInBinaryOpError extends UnexpectedTypeError {

	private Type found2;

	public UnexpectedTypeInBinaryOpError(Type expected, Type found1, Type found2, String exp) {
		super(expected, found1, exp);
		this.found2 = found2;
	}
	
	@Override
	public String toString(){
		return "Unexpected type in "+this.getExp()+", "+this.getExpected().toString()+", found "+this.getFound().toString()+" and "+found2.toString()+".";
	}
	
	@Override
	public int hashCode(){
		return toString().hashCode();
	}
		
	@Override
	public boolean equals(Object obj){
		if(obj == null)
			return false;
		
		if(obj instanceof UnexpectedTypeInBinaryOpError){
			UnexpectedTypeInBinaryOpError error = (UnexpectedTypeInBinaryOpError) obj;

			if(super.equals(error)){
				if(this.found2 == error.found2 || (this.found2 != null && this.found2.equals(error.found2))){
					return true;
				}
			}
			return false;	
		}
		return false;
	}

}
