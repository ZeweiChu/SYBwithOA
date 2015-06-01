package example_StmAlg;

import library.Monoid;
import monoid.StringMonoid;
import query.StmAlgQuery;

public class StringQuery implements StmAlgQuery<String> {
	public Monoid<String> m() {return new StringMonoid();}
	public String SDecl(String t, String v) {return v;}
}
