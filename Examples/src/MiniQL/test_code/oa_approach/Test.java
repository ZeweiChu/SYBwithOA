package MiniQL.test_code.oa_approach;

import java.util.Arrays;
import java.util.Set;
import MiniQL.oa_interface.QLAlg;

public class Test {
	<E, S, F> F makeQL(QLAlg<E, S, F> alg) {
		S s0 = alg.Question("name", "What is your name?", "string");
		S s1 = alg.Question("age", "What is your age?", "integer");
		E ifStmt = alg.GEq(alg.Var("age"), alg.Lit(18));
		S thenStmt = alg.Question("license", "Do you have a driver's license?", "boolean");
		S s2 = alg.If(ifStmt, thenStmt);
		return alg.Form("DriverLicense", Arrays.asList(s0, s1, s2));		
	}
	public Set<String> usedVars() {
		return makeQL(new UsedVars());
	}
	public Set<String> usedVarsAfterRenaming() {
		return makeQL(new Rename<>(new UsedVars()));
	}
}
