package lambAlgWithShy;

public class Print implements ExpAlg<String>, LamAlg<String> {
	public String Var(String s) { return s; }
	public String Lit(int i) { return "" + i; }
	public String Add(String e1, String e2) { return "(+ " + e1 + " " + e2 + ")"; }
	public String Lam(String x, String e) { return "(lambda (" + x +  ") " + e + ")"; }
	public String App(String e1, String e2) { return "(" + e1 + " " + e2 + ")"; }
}
