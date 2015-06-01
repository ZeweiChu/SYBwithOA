package expressionWithShy;
import query.ExpAlgQuery;
import library.Monoid;

public class FreeVarsQueryExpAlg implements ExpAlgQuery<String[]> {
	private Monoid<String[]> m;
	public FreeVarsQueryExpAlg(Monoid<String[]> m) {this.m = m;}
	@Override
	public Monoid<String[]> m() {return m;}
	@Override
	public String[] Var(String s) {return new String[]{s};}
}
