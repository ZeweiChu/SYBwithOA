package ExpAlg.test_code.extensibility;

import java.util.Set;
import query.ExpAlgQuery;
import query.LamAlgQuery;
import static java.util.Collections.singleton;
import static java.util.stream.Collectors.toSet;

class FreeVarsWithLambdas {

	interface FreeVars extends ExpAlgQuery<Set<String>> {
		default Set<String> Var(String s) {
			return singleton(s);
		}
	}

	interface FreeVarsWithLambda extends FreeVars, LamAlgQuery<Set<String>> {
		default Set<String> Lam(String x,Set<String> f) {
			return f.stream().filter(y -> !y.equals(x))
					       .collect(toSet());
		}
	}

}
