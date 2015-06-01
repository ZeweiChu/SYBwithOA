package example_SybAlg;

import library.Monoid;
import monoid.StringMonoid;
import query.OneOhOneAlgQuery;

public class StringQuery implements OneOhOneAlgQuery<String> {
	public Monoid<String> m() {return new StringMonoid();}
	public String P(String name, String address) {return name;}
}
