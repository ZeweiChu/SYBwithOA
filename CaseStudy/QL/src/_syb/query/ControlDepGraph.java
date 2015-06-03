package _syb.query;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import library.Pair;
import ql_obj_alg.check.types.Type;
import query.G_IFormAlgQuery;
import query.G_IStmtAlgQuery;

public interface ControlDepGraph
		extends
		G_IFormAlgQuery<Set<String>, Set<Pair<String, String>>, Set<Pair<String, String>>>,
		G_IStmtAlgQuery<Set<String>, Set<Pair<String, String>>> {

	
	@Override 
	default Set<Pair<String, String>> form(String p0,List<Set<Pair<String, String>>> p1) {
		return mS().fold(p1);
	}
	
	@Override 
	default Set<Pair<String, String>> iff(Set<String> p0, Set<Pair<String, String>> p1) {
		return iffelse(p0, p1, block(Collections.emptyList()));
	}
	
	@Override 
	default Set<Pair<String, String>> iffelse(Set<String> p0, Set<Pair<String, String>> p1, Set<Pair<String, String>> p2) {
		Set<Pair<String,String>> result = new HashSet<>();
		for (Set<Pair<String,String>> s: Arrays.asList(p1, p2)) {
			for (Pair<String,String> x: s) {
				if (x.b().equals("")) {
					for (String c: p0) {
						result.add(new Pair<>(x.a(), c));
					}
				}
			}
		}
		return mS().join(p1, mS().join(p2, result));
	}
	
	
	@Override 
	default Set<Pair<String, String>> question(String p0,String p1,Type p2) {
		return Collections.singleton(new Pair<>(p0, ""));
	}

	@Override 
	default Set<Pair<String, String>> question(String p0,String p1,Type p2,Set<String> p3) {
		return Collections.singleton(new Pair<>(p0, ""));
	}
	
}
