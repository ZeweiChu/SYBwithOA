package _syb.trafo;

import java.util.Map;

import ql_obj_alg.check.types.Type;
import transform.IExpAlgTransform;
import transform.IStmtAlgTransform;

public interface RenameVariable<E, S> extends IExpAlgTransform<E>, IStmtAlgTransform<E, S> {
	default String rename(String old) {
		String newName = old;
		if (renaming().containsKey(old)) {
			newName = renaming().get(old);
			//System.err.println("Renaming " + old + " to " + newName);
		}
		return newName;
	}
	
	Map<String, String> renaming();
	
	@Override 
	default E var(String varName) {
		return iExpAlg().var(rename(varName));
	}
	
	@Override 
	default S question(String id,String label,Type type) {
		return iStmtAlg().question(rename(id), label, type);
	}
	
	@Override 
	default S question(String id,String label,Type type,E exp) {
		return iStmtAlg().question(rename(id), label, type, exp);
	}
	
}
