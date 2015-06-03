package _syb;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import library.Monoid;
import library.Pair;
import monoids.PairMonoid;
import monoids.SetMonoid;
import noa.Builder;
import noa.Union;
import ql_obj_alg.check.types.Type;
import ql_obj_alg.parse.TheParser;
import ql_obj_alg.syntax.IAllAlg;
import query.IExpAlgQuery;


public class DepGraph {
	/*
	 * Collect the data and control dependency graph based on variable use and definition
	 * This could be split into 
	 * - data dep (visit only computed questions)
	 * - control dep (visit iff/iffelse, and questions similar to the current code)
	 * 
	 * So currently, it is not very structure-shy... 
	 */
	
//	interface Deps extends IStmtAlgQueryManySorted<Set<String>, Pair<Set<String>, Set<Pair<String,String>>>> {
//
//		Monoid<Pair<Set<String>, Set<Pair<String, String>>>> m();
//		
//		
//		@Override
//		public Pair<Set<String>, Set<Pair<String, String>>> iff(Set<String> cond, List<Pair<Set<String>, Set<Pair<String, String>>>> then) {
//			return iffelse(cond, then, Collections.emptyList());
//		}
//		
//		@Override
//		public Pair<Set<String>, Set<Pair<String, String>>> iffelse(Set<String> cond, 
//				List<Pair<Set<String>, Set<Pair<String, String>>>> then,
//				List<Pair<Set<String>, Set<Pair<String, String>>>> els) {
//			
//			Pair<Set<String>, Set<Pair<String, String>>> result = m().empty();
//			
//			result = propagate(result, then);
//			result = propagate(result, els);
//			result = addDeps(result, cond, then);
//			result = addDeps(result, cond, els);
//			
//			return result;
//		}
//		
//		private Pair<Set<String>, Set<Pair<String,String>>> propagate(Pair<Set<String>, Set<Pair<String, String>>> result, List<Pair<Set<String>, Set<Pair<String, String>>>> block) {
//			for (Pair<Set<String>, Set<Pair<String,String>>> p: block) {
//				result = m().join(result, p);
//			}
//			return result;
//		}
//		
//		private Pair<Set<String>, Set<Pair<String, String>>> addDeps(Pair<Set<String>, Set<Pair<String, String>>> result, Set<String> cond, List<Pair<Set<String>, Set<Pair<String, String>>>> block) {
//			Set<Pair<String, String>> deps = new HashSet<>();
//			for (Pair<Set<String>, Set<Pair<String,String>>> p: block) {
//				for (String def: p.a()) {
//					for (String use: cond) {
//						deps.add(new Pair<>(def, use));
//					}
//				}
//			}
//			return m().join(result, new Pair<>(Collections.emptySet(), deps));
//		}
//
//		@Override
//		public Pair<Set<String>, Set<Pair<String, String>>> question(String name, String label, Type t) {
//			return new Pair<>(Collections.singleton(name), Collections.emptySet());
//		}
//		
//		@Override
//		public Pair<Set<String>, Set<Pair<String, String>>> question(String name, String label, Type t, Set<String> exp) {
//			Set<Pair<String,String>> deps = new HashSet<>();
//			for (String use: exp) {
//				deps.add(new Pair<>(name, use));
//			}
//			return new Pair<>(Collections.singleton(name), deps);
//		}
//		
//	}
//
//	public static void main(String[] args) throws FileNotFoundException, IOException {
//		Builder builder = TheParser.parse(new FileInputStream("resources/inputfiles/test.QL"));
//		
//		IExpAlgQuery<Set<String>> e = new FreeVars(new SetMonoid<>());
//		IStmtAlgQueryManySorted<Set<String>, Pair<Set<String>, Set<Pair<String,String>>>> s = new Deps(new PairMonoid<>(new SetMonoid<>(), new SetMonoid<>()));
//		IFormAlgQueryManySorted<Set<String>, Pair<Set<String>, Set<Pair<String,String>>>> f = new IFormAlgQueryManySorted<>(new PairMonoid<>(new SetMonoid<>(), new SetMonoid<>()));
//		
//		Pair<Set<String>, Set<Pair<String,String>>> deps = builder.build(Union.union(IAllAlg.class, f, s, e));
//		System.out.println(deps.b());
//	}
	
}
