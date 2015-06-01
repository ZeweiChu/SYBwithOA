package deps1;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import library.Pair;
import trees.ExpAlg;
import trees.StatAlg;

//BEGIN_DEPS1
public interface DepGraph extends ExpAlg<Set<String>>, StatAlg<Set<String>, Set<Pair<String,String>>> {
	default Set<String> Var(String p0) {return Collections.singleton(p0);}
	default Set<String> Lit(int i){return Collections.emptySet();}
	default Set<String> Add(Set<String> e1, Set<String> e2){
		Set<String> deps = new HashSet<>(e1);
		deps.addAll(e2);
		return deps;}
	default Set<Pair<String, String>> Assign(String p0,Set<String> p1) {
		Set<Pair<String,String>> deps = new HashSet<>();
		for (String x: p1) {deps.add(new Pair<>(p0, x));}
		return deps;}
	default Set<Pair<String, String>> Seq(Set<Pair<String, String>> s1, Set<Pair<String, String>> s2){
		Set<Pair<String, String>> deps = new HashSet<>(s1);
		deps.addAll(s2);
		return deps;}
}
//END_DEPS1