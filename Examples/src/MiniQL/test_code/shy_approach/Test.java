package MiniQL.test_code.shy_approach;

import java.util.Arrays;
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
	
	void println(Object o) {
		System.out.println(o);
	}
	
	void go() {
		println(makeQL(new UsedVars()));
		println(makeQL(new Rename<>(new UsedVars())));
	}
	
	public static void main(String args[]) {
		Test t = new Test();
		t.go();
	}
	
}
