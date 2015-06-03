package _syb.query;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;

import library.Monoid;
import monoids.SetMonoid;
import noa.Builder;
import ql_obj_alg.parse.TheParser;
import query.IFormAlgQuery;
import query.IStmtAlgQuery;

public class TestFreeVars {

	static class DoIt implements FreeVars, IStmtAlgQuery<Set<String>>, IFormAlgQuery<Set<String>> {
		@Override
		public Monoid<Set<String>> m() {
			return new SetMonoid<>();
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Builder builder = TheParser.parse(new FileInputStream(
				"resources/inputfiles/test.QL"));
		
		Set<String> fv = builder.build(new DoIt());
		
		System.out.println(fv);
	}
	
}
