package _syb.query;

import java.util.Collections;
import java.util.Set;

import query.IExpAlgQuery;

public interface FreeVars extends IExpAlgQuery<Set<String>> {
	
	@Override 
	default Set<String> var(String varName) {
		return Collections.singleton(varName);
	}
	
}
