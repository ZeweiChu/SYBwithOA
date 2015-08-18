package ExpAlg.test_code.generalized_query;

import java.util.Set;

import library.Pair;
import ExpAlg.oa_interface.ExpAlg;
import ExpAlg.oa_interface.StatAlg;

public class TestDepGraph {	
	<E, S, A extends ExpAlg<E> & StatAlg<E, S>> S makeStat(A alg) {
		return alg.Seq(
				alg.Assign("x", alg.Add(alg.Var("x"),
						alg.Lit(3))), 
				alg.Assign("y", alg.Add(alg.Var("x"),
						alg.Var("z"))));
	}
	public Set<Pair<String, String>> depGraph() {
		return makeStat(new DepGraph(){});
	}
}
