package MiniQL.test_code.shy_approach;

import java.util.Arrays;
import java.util.Set;

import MiniQL.oa_interface.QLAlg;

public class Test {	
	<E, S, F> F makeQL(QLAlg<E, S, F> alg) {
		return alg.Form("DriverLicense", Arrays.asList(
				alg.Question("name", "Name?", "string"), 
				alg.Question("age", "Age?", "integer"), 
				alg.If(alg.GEq(alg.Var("age"), 
						               alg.Lit(18)), 
					           alg.Question("license", 
					        		   "License?", "boolean"))));		
	}
	public Set<String> usedVars() {
		return makeQL(new UsedVars());
	}
	public Set<String> usedVarsAfterRenaming() {
		return makeQL(new Rename<>(new UsedVars()));
	}	
}
