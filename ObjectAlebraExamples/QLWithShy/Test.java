package QLWithShy;

import java.util.Arrays;
import trees.QLAlg;

public class Test {
	
	//BEGIN_CLIENTCODE_MAKEQL
	<E, S, F> F makeQL(QLAlg<E, S, F> alg) {
		return alg.Form("DriverLicense", Arrays.asList(
				alg.Question("name", "Name?", "string"), 
				alg.Question("age", "Age?", "integer"), 
				alg.If(alg.GEq(alg.Var("age"), 
						               alg.Lit(18)), 
					           alg.Question("license", 
					        		   "License?", "boolean"))));		
	}
	//END_CLIENTCODE_MAKEQL
	
	void println(Object o) {
		System.out.println(o);
	}
	
	void go() {
		//BEGIN_CLIENTCODE_QLTEST
		println(makeQL(new UsedVars()));
		println(makeQL(new Rename<>(new UsedVars())));
		//END_CLIENTCODE_QLTEST
	}
	
	public static void main(String args[]) {
		Test t = new Test();
		t.go();
	}
	
}
