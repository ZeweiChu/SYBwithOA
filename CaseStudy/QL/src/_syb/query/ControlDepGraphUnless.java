package _syb.query;

import java.util.Set;

import library.Pair;
import query.G_IStmtAlgQuery;
import query.G_IUnlessAlgQuery;

//BEGIN_CONTROLDEPS_UNLESS
public interface ControlDepGraphUnless extends 
  G_IStmtAlgQuery<Set<String>, Set<Pair<String, String>>>,
  G_IUnlessAlgQuery<Set<String>, Set<Pair<String, String>>> {

	@Override 
	default Set<Pair<String, String>> unless(Set<String> p0, Set<Pair<String, String>> p1) {
		return iff(p0, p1);
	}
}
//END_CONTROLDEPS_UNLESS
