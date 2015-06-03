package _syb.query;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;

import library.Monoid;
import library.Pair;
import monoids.SetMonoid;
import noa.Builder;
import ql_obj_alg.parse.TheParser;

public class TestDataDepGraph {
	
	static class DoIt implements DataDepGraph, FreeVars {
		private SetMonoid<String> fvMonoid = new SetMonoid<String>();
		private SetMonoid<Pair<String, String>> depMonoid = new SetMonoid<Pair<String, String>>();

		@Override
		public Monoid<Set<String>> m() {
			return fvMonoid;
		}
		
		@Override
		public Monoid<Set<String>> mE() {
			return fvMonoid;
		}
		
		@Override
		public Monoid<Set<Pair<String,String>>> mF() {
			return depMonoid;
		}
		
		@Override
		public Monoid<Set<Pair<String,String>>> mS() {
			return depMonoid;
		}
		
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Builder builder = TheParser.parse(new FileInputStream(
				"resources/inputfiles/test.QL"));
		
		Set<Pair<String,String>> deps = builder.build(new DoIt());
		
		System.out.println(deps);
	}
	
}
