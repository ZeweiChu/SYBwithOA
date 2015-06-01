package QLWithShy;

import trees.QLAlg;
import util.QLAlgTrans;

//BEGIN_QL_TRANSFORM_WITH_OAFRAMEWORK
class Rename<E, S, F> extends QLAlgTrans<E, S, F> {	
	public Rename(QLAlg<E, S, F> alg) { super(alg); }
	public S Question(String n, String l, String t) {
		return qLAlg().Question(n + "_", l, t);
	}
	public E Var(String x) {
		return qLAlg().Var(x + "_");
	}
}
//END_QL_TRANSFORM_WITH_OAFRAMEWORK
