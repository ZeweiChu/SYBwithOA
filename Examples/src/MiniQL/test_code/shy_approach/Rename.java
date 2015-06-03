package MiniQL.test_code.shy_approach;

import MiniQL.oa_interface.QLAlg;
import util.QLAlgTrans;

class Rename<E, S, F> extends QLAlgTrans<E, S, F> {	
	public Rename(QLAlg<E, S, F> alg) { super(alg); }
	public S Question(String n, String l, String t) {
		return qLAlg().Question(n + "_", l, t);
	}
	public E Var(String x) {
		return qLAlg().Var(x + "_");
	}
}
