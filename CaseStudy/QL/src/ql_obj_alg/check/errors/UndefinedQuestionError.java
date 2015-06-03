package ql_obj_alg.check.errors;

public class UndefinedQuestionError extends GenError{
	private String varName;
	
	public UndefinedQuestionError(String varName){
		this.varName = varName;
	}
	
	@Override
	public String toString(){
		return "Undefined varName: "+varName;
	}
	
	@Override
	public int hashCode(){
		return toString().hashCode();
	}
		
	@Override
	public boolean equals(Object obj){
		if(obj == null)
			return false;
		
		if(obj instanceof UndefinedQuestionError){
			UndefinedQuestionError error = (UndefinedQuestionError) obj;	
			if(this.varName == error.varName || (this.varName != null && this.varName.equals(error.varName)))
				return true;
		}
		return false;
	}

}
