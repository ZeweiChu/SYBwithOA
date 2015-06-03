package MiniQL.test_code.oa_approach;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import MiniQL.oa_interface.QLAlg;

class UsedVars implements 
   QLAlg<Set<String>, Set<String>, Set<String>> {
	
	public Set<String> Form(String n, 
			               List<Set<String>> b) {
		Set<String> vars = new HashSet<>();
		b.forEach(s -> vars.addAll(s));
		return vars;
	}
	
	public Set<String> If(Set<String> c, Set<String> t) {
		Set<String> vars = new HashSet<>(c);
		vars.addAll(t);
		return vars;
	}
	
	public Set<String> Question(String n, String l, String t) {
		return Collections.emptySet();
	}
	
	public Set<String> Lit(int x) { 
		return Collections.emptySet(); 
	}
	
	public Set<String> Var(String x) { 
		return Collections.singleton(x); 
	}

	public Set<String> GEq(Set<String> l, Set<String> r) {
		Set<String> vars = new HashSet<>(l);
		vars.addAll(r);
		return vars;
	}
}
