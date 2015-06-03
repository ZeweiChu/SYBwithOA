package _syb.query;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

import _syb.trafo.TestInlineConditionsUnless.DoIt;
import library.Monoid;
import library.Pair;
import monoids.SetMonoid;
import noa.Builder;
import ql_obj_alg.box.IFormat;
import ql_obj_alg.check.types.TBoolean;
import ql_obj_alg.format.IFormatWithPrecedence;
import ql_obj_alg.parse.TheParser;

public class TestControlDepsUnless {

	public static class DoIt implements ControlDepGraph, FreeVars, ControlDepGraphUnless {
		
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
		
		DoIt d = new DoIt();
		Set<Pair<String,String>> deps = d.form("bla", 
				Arrays.asList(d.unless(d.var("y"), d.block(Arrays.asList(d.question("x", "X?", new TBoolean()))))));
		
		
		Set<Pair<String,String>> del = new HashSet<>();
		for (Pair<String,String> dep: deps) {
			if (dep.b().equals("")) {
				del.add(dep);
			}
		}
		deps.removeAll(del);
		System.out.println(deps);
	}
	
}