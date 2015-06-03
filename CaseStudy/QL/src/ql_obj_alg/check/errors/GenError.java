package ql_obj_alg.check.errors;

public class GenError {
	
	public String toString(){
		return "Unknown error";
	}
	
	@Override
	public int hashCode(){
		return toString().hashCode();
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj == null)
			return false;
		
		if(obj instanceof GenError){
			return true;
		}
		return false;
	}
}
