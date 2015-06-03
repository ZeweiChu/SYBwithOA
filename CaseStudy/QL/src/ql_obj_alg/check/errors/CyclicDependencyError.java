package ql_obj_alg.check.errors;

import ql_obj_alg.cycles.Cycle;

public class CyclicDependencyError extends GenError {
	private Cycle cycle;
	
	public CyclicDependencyError(Cycle cycle){
		this.cycle = cycle;
	}
	
	@Override
	public String toString(){
		return "Cyclic dependency: "+cycle.toString()+".";
	}
	
	@Override
	public int hashCode(){
		return toString().hashCode();
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj == null)
			return false;
		
		if(obj instanceof CyclicDependencyError){
			CyclicDependencyError other = (CyclicDependencyError) obj;		
			if(this.cycle == other.cycle || (this.cycle != null && this.cycle.equals(other.cycle)))
				return true;
		}
		return false;
	}
}
