package expressionWithOAandGenerics;

import java.util.Set;

import static java.util.Collections.singleton;
import static java.util.stream.Collectors.toSet;

class FreeVarsWithLambdas {

	// special version to avoid implementation of m()
	interface FreeVars extends ExpAlgQuery<Set<String>> {
		default Set<String> Var(String s) {
			return singleton(s);
		}
	}

	// BEGIN_EXTENDFREEVARS
	interface FreeVarsWithLambda extends FreeVars, LamAlgQuery<Set<String>> {
		default Set<String> Lam(String x,Set<String> f) {
			return f.stream().filter(y -> !y.equals(x))
					       .collect(toSet());
		}
	}
	// END_EXTENDFREEVARS

}
