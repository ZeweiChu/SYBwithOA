package ExpAlg.test_code.transform.oa_approach;

import java.util.Set;
import ExpAlg.oa_interface.ExpAlg;
import ExpAlg.test_code.query.oa_approach.FreeVars;

public class Test {
	<E> E makeExp(ExpAlg<E> alg) {
		return alg.Add(alg.Add(alg.Var("x"), alg.Var("y")), alg.Lit(3));
	}
	public Set<String> freeVarsAfterSubst() {
		SubstVar<Set<String>> subst = new SubstVar<Set<String>>(){
			public ExpAlg<Set<String>> expAlg() { return new FreeVars(){}; }
			public String x() { return "y"; }
			public Set<String> e() { return expAlg().Var("z"); }
		};
		return makeExp(subst);
	}
}
