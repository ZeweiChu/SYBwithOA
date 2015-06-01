package expressionWithOAandGenerics;

import java.util.Collections;
import java.util.Set;

//BEGIN_FREEVARS_WITH_MONOID
interface FreeVars extends ExpAlgQuery<Set<String>>
{
	default Monoid<Set<String>> m() {
		return new SetMonoid<String>();
	}
	default Set<String> Var(String s) {
		return Collections.singleton(s);
	}
}
//END_FREEVARS_WITH_MONOID
