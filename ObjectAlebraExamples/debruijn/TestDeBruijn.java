package debruijn;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import trees.ExpAlg;
import trees.LamAlg;

public class TestDeBruijn {

	static class PrintLambdaExp implements ExpAlg<String>, LamAlg<String> {

		@Override
		public String Lam(String x, String e) {
			return "\\" + x + "." + e;
		}

		@Override
		public String Apply(String e1, String e2) {
			return "(" + e1 + " " + e2 + ")";
		}

		@Override
		public String Var(String s) {
			return s;
		}

		@Override
		public String Lit(int i) {
			return i + "";
		}

		@Override
		public String Add(String e1, String e2) {
			return "(" + e1 + " + " + e2 + ")";
		}
		
	}
	
	static class DoIt implements DeBruijn<String> {
		PrintLambdaExp alg = new PrintLambdaExp();
		
		@Override
		public ExpAlg<String> expAlg() {
			return alg;
		}
		
		@Override
		public LamAlg<String> lamAlg() {
			return alg;
		}
	}
	
	void go() {
//BEGIN_CLIENTCODE_DEBRUIJN		
DeBruijn<String> deBruijn = new DeBruijn<String>() {
	Printer alg = new Printer();
	public ExpAlg<String> expAlg() { return alg; }
	public LamAlg<String> lamAlg() { return alg; }
};
println(makeLamExp(deBruijn)
		.apply(Collections.emptyList()));
//END_CLIENTCODE_DEBRUIJN		
	}
	
	void println(Object o) { System.out.println(o); }
//BEGIN_MAKE_LAM_EXP	
<E, A extends ExpAlg<E> & LamAlg<E>>
		E makeLamExp(A alg) {
	return alg.Lam("x", alg.Lam("y",
			alg.Add(alg.Var("x"), alg.Var("y"))));
}
//END_MAKE_LAM_EXP
	
	
	public static void main(String[] args) {
		DoIt d = new DoIt();
		Function<List<String>, String> f = d.Lam("x", d.Lam("y", d.Lam("z", d.Apply(d.Apply(d.Var("x"), d.Var("z")), d.Apply(d.Var("y"), d.Var("z"))))));
		String s = f.apply(Collections.emptyList());
		System.out.println(s);

		f = d.Lam("x", d.Lam("y", d.Add(d.Var("x"), d.Var("y"))));
		s = f.apply(Collections.emptyList());
		System.out.println(s);
		
		TestDeBruijn t = new TestDeBruijn();
		t.go();

	}
}

//BEGIN_LAMALG_PRINTER
class Printer implements ExpAlg<String>,
		LamAlg<String> {
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
//END_LAMALG_PRINTER

