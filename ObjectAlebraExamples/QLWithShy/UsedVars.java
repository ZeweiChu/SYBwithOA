package QLWithShy;

import java.util.Collections;
import java.util.Set;
import library.Monoid;
import monoid.SetMonoid;
import query.QLAlgQuery;

//BEGIN_QL_QUERY_WITH_OAFRAMEWORK
class UsedVars implements QLAlgQuery<Set<String>> {
	public Monoid<Set<String>> m() {
		return new SetMonoid<String>();
	}
	public Set<String> Var(String name) {
		return Collections.singleton(name);
	}
}
//END_QL_QUERY_WITH_OAFRAMEWORK
