package AutoTest;

import static org.junit.Assert.assertEquals;

import java.util.*;

import library.Pair;

import org.junit.Test;

public class AutoTest {
	@Test
	public void testObjectAlgebras() {
		ObjectAlgebras.ObjectAlgebras oa = new ObjectAlgebras.ObjectAlgebras();
		assertEquals(5, oa.evalExp());
		assertEquals("2 + 3", oa.printExp());
		assertEquals(20, oa.evalMul());
	}
	@Test
	public void testMiniQL() {
		MiniQL.test_code.oo_approach.Test oo = new MiniQL.test_code.oo_approach.Test();
		assertEquals(Collections.singleton("age"), oo.usedVars());
		assertEquals(Collections.singleton("age_"), oo.usedVarsAfterRenaming());
		MiniQL.test_code.oa_approach.Test oa = new MiniQL.test_code.oa_approach.Test();
		assertEquals(Collections.singleton("age"), oa.usedVars());
		assertEquals(Collections.singleton("age_"), oa.usedVarsAfterRenaming());
		MiniQL.test_code.oa_approach.Test shy = new MiniQL.test_code.oa_approach.Test();
		assertEquals(Collections.singleton("age"), shy.usedVars());
		assertEquals(Collections.singleton("age_"), shy.usedVarsAfterRenaming());
	}
	@Test
	public void testExpAlg_query() {
		Set<String> res = new HashSet<>();
		res.add("x"); res.add("y");
		ExpAlg.test_code.query.oa_approach.Test oa = new ExpAlg.test_code.query.oa_approach.Test();
		assertEquals(res, oa.freeVars());
		ExpAlg.test_code.query.shy_approach.Test shy = new ExpAlg.test_code.query.shy_approach.Test();
		assertEquals(res, shy.freeVars());
	}
	@Test
	public void testExpAlg_transform() {
		Set<String> res = new HashSet<>();
		res.add("x"); res.add("z");
		ExpAlg.test_code.transform.oa_approach.Test oa = new ExpAlg.test_code.transform.oa_approach.Test();
		assertEquals(res, oa.freeVarsAfterSubst());
		ExpAlg.test_code.transform.shy_approach.Test shy = new ExpAlg.test_code.transform.shy_approach.Test();
		assertEquals(res, shy.freeVarsAfterSubst());
	}
	@Test
	public void testExpAlg_generalized_query() {
		Set<Pair<String, String>> res = new HashSet<>();
		res.add(new Pair<>("x", "x"));
		res.add(new Pair<>("y", "x"));
		res.add(new Pair<>("y", "z"));
		ExpAlg.test_code.generalized_query.TestDepGraph t = new ExpAlg.test_code.generalized_query.TestDepGraph();
		assertEquals(res, t.depGraph());
	}
	@Test
	public void testExpAlg_contextual_transform() {
		ExpAlg.test_code.contextual_transform.TestDeBruijn t = new ExpAlg.test_code.contextual_transform.TestDeBruijn();
		assertEquals("\\.\\.(2 + 1)", t.deBruijn());
	}
	@Test
	public void testExpAlg_extensibility() {
		ExpAlg.test_code.extensibility.TestFreeVarsWithLambda fv = new ExpAlg.test_code.extensibility.TestFreeVarsWithLambda();
		assertEquals(Collections.singleton("y"), fv.freeVarsWithLambda());
		ExpAlg.test_code.extensibility.TestUniqueWithLambda u = new ExpAlg.test_code.extensibility.TestUniqueWithLambda();
		Set<String> res = new HashSet<>();
		res.add("x0"); res.add("y1");
		assertEquals(res, u.uniqueWithLambda());
	}
}
