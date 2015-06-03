package MiniQL.test_code.oa_approach;

import java.util.List;
import MiniQL.oa_interface.QLAlg;

class Rename<E, S, F> implements QLAlg<E, S, F> {
	private QLAlg<E, S, F> alg;	
	public Rename(QLAlg<E, S, F> alg) {
		this.alg = alg;
	}	
	public F Form(String id, List<S> stmts) {
		return alg.Form(id, stmts);
	}
	public S If(E cond, S then) {
		return alg.If(cond, then);
	}
	public S Question(String id, String lbl,
			String type) {
		return alg.Question(id + "_", lbl, type);
	}
	public E Lit(int x) { return alg.Lit(x); }
	public E Var(String name) {
		return alg.Var(name + "_");
	}
	public E GEq(E lhs, E rhs) {
		return alg.GEq(lhs, rhs);
	}
}
