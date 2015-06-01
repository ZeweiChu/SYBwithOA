package deps1;

import java.util.Set;

import trees.ExpAlg;
import trees.StatAlg;
import library.Pair;

public class TestDepGraph {

	static <E, S, Alg extends ExpAlg<E> & StatAlg<E, S>> S build(Alg alg) {
		return alg.Seq(alg.Assign("x", alg.Add(alg.Var("x"), alg.Lit(3))), 
				alg.Assign("y", alg.Add(alg.Var("x"), alg.Var("z"))));
	}
	
	public static void main(String[] args) {
		DepGraph doIt = new DepGraph(){};
		Set<Pair<String, String>> result = build(doIt);
		System.out.println(result);
	}
}
