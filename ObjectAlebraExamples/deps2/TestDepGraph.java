package deps2;

import trees.ExpAlg;
import trees.StatAlg;

public class TestDepGraph {

//BEGIN_GEN_DEPGRAPH
<E, S, A extends ExpAlg<E> & StatAlg<E, S>>
		S makeStat(A alg) {
	return alg.Seq(
			alg.Assign("x", alg.Add(alg.Var("x"),
					alg.Lit(3))), 
			alg.Assign("y", alg.Add(alg.Var("x"),
					alg.Var("z"))));
}
//END_GEN_DEPGRAPH

	void Test() {

//BEGIN_CLIENTCODE_DEPGRAPH
println(makeStat(new DepGraph(){}));
//END_CLIENTCODE_DEPGRAPH

	}
	
	void println(Object o) { System.out.println(o); }
	
	public static void main(String[] args) {
		TestDepGraph testDepGraph = new TestDepGraph();
		testDepGraph.Test();
	}
}
