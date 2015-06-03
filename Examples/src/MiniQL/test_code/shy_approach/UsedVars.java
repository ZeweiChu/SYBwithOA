package MiniQL.test_code.shy_approach;

import java.util.Collections;
import java.util.Set;
import Utils.SetMonoid;
import library.Monoid;
import query.QLAlgQuery;

class UsedVars implements QLAlgQuery<Set<String>> {
	public Monoid<Set<String>> m() {
		return new SetMonoid<String>();
	}
	public Set<String> Var(String name) {
		return Collections.singleton(name);
	}
}
