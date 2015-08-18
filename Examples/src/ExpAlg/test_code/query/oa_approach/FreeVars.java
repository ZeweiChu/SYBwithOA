package ExpAlg.test_code.query.oa_approach;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import ExpAlg.oa_interface.ExpAlg;

public interface FreeVars extends ExpAlg<Set<String>> {
	default Set<String> Var(String s) {
		return Collections.singleton(s);
	}
	default Set<String> Lit(int i) {
		return Collections.emptySet();
	}
	default Set<String> Add(Set<String> e1, Set<String> e2) {
		return Stream.concat(e1.stream(), e2.stream()).collect(Collectors.toSet());
	}
}
