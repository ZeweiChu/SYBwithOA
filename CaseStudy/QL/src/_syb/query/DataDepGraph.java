package _syb.query;

import java.util.HashSet;
import java.util.Set;

import library.Pair;
import ql_obj_alg.check.types.Type;
import query.G_IFormAlgQuery;
import query.G_IStmtAlgQuery;

public interface DataDepGraph extends 
	G_IFormAlgQuery<Set<String>, Set<Pair<String, String>>, Set<Pair<String, String>>>,
	G_IStmtAlgQuery<Set<String>, Set<Pair<String, String>>> {
	
	default java.util.Set<Pair<String,String>> form(String p0, java.util.List<java.util.Set<Pair<String, String>>> p1) {
		return mS().fold(p1);
	};
	
	@Override 
	default Set<Pair<String,String>> question(String p0,String p1,Type p2,Set<String> p3) {
		Set<Pair<String,String>> deps = new HashSet<>(); //.empty();
		for (String x: p3) {
			deps.add(new Pair<>(p0, x));
		}
		return deps;
	}
	
	@Override
	default Set<Pair<String, String>> iff(Set<String> p0, Set<Pair<String,String>> p1) {
		return p1;
	}

	@Override
	default Set<Pair<String, String>> iffelse(Set<String> p0, Set<Pair<String,String>> p1, Set<Pair<String,String>> p2) {
		return mS().join(p1, p2);
	}

}
