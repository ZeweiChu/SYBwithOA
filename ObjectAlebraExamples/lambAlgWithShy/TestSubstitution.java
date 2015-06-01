package lambAlgWithShy;

import java.util.Collections;

public class TestSubstitution {
	
	static <E, Alg extends ExpAlg<E> & LamAlg<E>> E genExp(Alg alg) {
		return alg.Lam("x", alg.Lam("y", alg.Lam("x", alg.Add(alg.Var("x"), alg.Var("y")))));
		//return alg.Lam("x", alg.Add(alg.Add(alg.Lit(3), alg.Add(alg.Var("x"), alg.Lam("x", alg.Var("y")))), alg.Add(alg.Var("y"), alg.Lam("y", alg.Var("y")))));
	}
	
	public static void main(String args[]) {
		Print print = new Print();
		Substitution<String> subst = new Substitution<String>() {
			public ExpAlg<String> expAlg() { return print; }
			public LamAlg<String> lamAlg() { return print; }
		};
		SubstArgs<String> substArgs = new SubstArgs<String>("y", print.Var("x"), Collections.singleton(print.Var("x")), Collections.emptyMap());
		System.out.println("Original: " + genExp(print));
		System.out.println("[x]");
		System.out.println("[y := x]: " + genExp(subst).apply(substArgs));
	}
	
}
