package ExpAlg.test_code.query.shy_approach;

import java.util.Collections;
import java.util.Set;
import Utils.SetMonoid;
import query.ExpAlgQuery;
import library.Monoid;

public interface FreeVars extends ExpAlgQuery<Set<String>> {
	default Monoid<Set<String>> m() {
		return new SetMonoid<String>();
	}
	default Set<String> Var(String s) {
		return Collections.singleton(s);
	}
}
