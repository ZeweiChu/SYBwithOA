package ExpAlg.test_code.query.oa_approach;

import java.util.Set;

import ExpAlg.oa_interface.ExpAlg;

public class Test {
	<E> E makeExp(ExpAlg<E> alg) {
		return alg.Add(alg.Add(alg.Var("x"), alg.Var("y")), alg.Lit(3));
	}
	public Set<String> freeVars() {
		return makeExp(new FreeVars(){});
	}
}
