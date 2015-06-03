package ql_obj_alg.check.errors;


public class DuplicateQuestionError extends GenError {
	private String varName;
	
	public DuplicateQuestionError(String variable){
		this.varName = variable;
	}
	
	@Override
	public String toString(){
		return "Duplicate declaration of question "+varName+".";
	}
	
	@Override
	public int hashCode(){
		return toString().hashCode();
	}
		
	@Override
	public boolean equals(Object obj){
		if(obj == null)
			return false;
		
		if(obj instanceof DuplicateQuestionError){
			DuplicateQuestionError error = (DuplicateQuestionError) obj;			
			if(this.varName == error.varName || (this.varName != null && this.varName.equals(error.varName)))
				return true;
		}
		return false;
	}
}
