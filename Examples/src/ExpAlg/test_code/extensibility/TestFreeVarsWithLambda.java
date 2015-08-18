package ExpAlg.test_code.extensibility;

import java.util.Set;
import Utils.SetMonoid;
import library.Monoid;

public class TestFreeVarsWithLambda {
	public Set<String> freeVarsWithLambda() {
		FreeVarsWithLambdas.FreeVarsWithLambda fv = new FreeVarsWithLambdas.FreeVarsWithLambda() { 
			public Monoid<Set<String>> m() { return new SetMonoid<>(); }
		};
		return fv.Lam("x", fv.Add(fv.Var("x"), fv.Var("y")));
	}
}
