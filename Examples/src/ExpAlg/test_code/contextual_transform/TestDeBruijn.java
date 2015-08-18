package ExpAlg.test_code.contextual_transform;

import java.util.Collections;
import ExpAlg.oa_interface.ExpAlg;
import ExpAlg.oa_interface.LamAlg;

public class TestDeBruijn {
	<E, A extends ExpAlg<E> & LamAlg<E>> E makeLamExp(A alg) {
		return alg.Lam("x", alg.Lam("y",
				alg.Add(alg.Var("x"), alg.Var("y"))));
	}
	public String deBruijn() {		
		DeBruijn<String> deBruijn = new DeBruijn<String>() {
			Printer alg = new Printer();
			public ExpAlg<String> expAlg() { return alg; }
			public LamAlg<String> lamAlg() { return alg; }
		};
		return makeLamExp(deBruijn).apply(Collections.emptyList());	
	}
}

class Printer implements ExpAlg<String>, LamAlg<String> {
	public String Lam(String x, String e) {
		return "\\" + x + "." + e;
	}
	public String Apply(String e1, String e2) {
		return "(" + e1 + " " + e2 + ")";
	}
	public String Var(String s) { return s; }
	public String Lit(int i) { return i + ""; }
	public String Add(String e1, String e2) {
		return "(" + e1 + " + " + e2 + ")";
	}
}
