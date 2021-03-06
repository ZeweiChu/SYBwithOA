package ExpAlg.test_code.generalized_query;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import Utils.SetMonoid;
import library.Monoid;
import library.Pair;
import query.G_ExpAlgQuery;
import query.G_StatAlgQuery;

interface DepGraph extends
		G_ExpAlgQuery<Set<String>>,
		G_StatAlgQuery<Set<String>, Set<Pair<String, String>>> {
	default Monoid<Set<String>> mExp(){
		return new SetMonoid<>();
	}
	default Monoid<Set<Pair<String, String>>> mStat(){
		return new SetMonoid<>();
	}
	default Set<String> Var(String x){
		return Collections.singleton(x);
	}
	default Set<Pair<String, String>> 
	            Assign(String x, Set<String> e){
		Set<Pair<String, String>> deps = new HashSet<>();
		e.forEach(y -> deps.add(new Pair<>(x, y)));
		return deps;
	}
}
