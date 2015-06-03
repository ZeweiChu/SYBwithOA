package ql_obj_alg.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ql_obj_alg.check.ErrorReporting;
import ql_obj_alg.check.errors.CyclicDependencyError;
import ql_obj_alg.check.errors.GenError;
import ql_obj_alg.check.types.TBoolean;
import ql_obj_alg.check.warnings.Warning;
import ql_obj_alg.cycles.Cycle;
import ql_obj_alg.cycles.DependencyGraph;
import ql_obj_alg.cycles.ExprDependencies;
import ql_obj_alg.cycles.FormDependencies;
import ql_obj_alg.cycles.IDetectCycle;
import ql_obj_alg.cycles.StmtDependencies;
import ql_obj_alg.syntax.IExpAlg;
import ql_obj_alg.syntax.IFormAlg;
import ql_obj_alg.syntax.IStmtAlg;

public class CyclicDependenciesTest{

	ErrorReporting report;
	DependencyGraph dcd;
	
	GenError expectedError;
	Warning expectedWarning;
	
	@Before
	public void setUp() throws Exception {
		report = new ErrorReporting();
		dcd = new DependencyGraph();
		expectedError = null;
		expectedWarning = null;
	}

	@Test
	public void testValueDependencyCycle() {
		
		IDetectCycle form = valueDependencyCycle(new FormDependencies(), new StmtDependencies(), new ExprDependencies());

		form.detect(report);
		
		assertEquals(0, report.numberOfWarnings());
		
		assertEquals(1,report.numberOfErrors());
		
		Cycle cycle = new Cycle();
		cycle.add("id1");
		expectedError = new CyclicDependencyError(cycle);
		
		assertTrue(report.containsError(expectedError));
	}
	
	private static <E,S,F> F valueDependencyCycle(IFormAlg<E,S,F> f, IStmtAlg<E,S> s, IExpAlg<E> e){
		List<S> level1 = new ArrayList<S>();
		level1.add(s.question("id1", "label", new TBoolean(),e.var("id1")));
		return f.form("Form id", level1);
	}
	
	
	@Test
	public void testDefinitionDependencyCycle() {
		IDetectCycle form = definitionDependencyCycle(new FormDependencies(), new StmtDependencies(), new ExprDependencies());

		form.detect(report);
		
		assertEquals(0, report.numberOfWarnings());
		
		assertEquals(1,report.numberOfErrors());
		
		Cycle cycle = new Cycle();
		cycle.add("Y");
		cycle.add("X");
		expectedError = new CyclicDependencyError(cycle);
		
		assertTrue(report.containsError(expectedError));
	}
	
	private static <E,S,F> F definitionDependencyCycle(IFormAlg<E,S,F> f, IStmtAlg<E,S> s, IExpAlg<E> e){
		List<S> level1 = new ArrayList<S>();
		List<S> level2 = new ArrayList<S>();
		
		level1.add(s.iff(e.var("X"), s.block(level2)));
		level2.add(s.question("Y", "label y", new TBoolean()));
		level2 = new ArrayList<S>();
		
		level1.add(s.iff(e.var("Y"), s.block(level2)));
		level2.add(s.question("X", "label x", new TBoolean()));
		
		return f.form("Form id", level1);
	}
	

	
	@Test
	public void testNestedDependencyCycle() {
		IDetectCycle form = nestedDependencyCycle(new FormDependencies(), new StmtDependencies(), new ExprDependencies());

		form.detect(report);
		
		assertEquals(0, report.numberOfWarnings());
		
		assertEquals(2,report.numberOfErrors());

		Cycle cycle1 = new Cycle();
		
		cycle1.add("X1");
		cycle1.add("X3");
		
		Cycle cycle2 = new Cycle();
		
		cycle2.add("X1");
		cycle2.add("X3");
		cycle2.add("X2");
		
		expectedError = new CyclicDependencyError(cycle1);
		assertTrue(report.containsError(expectedError));
		
		expectedError = new CyclicDependencyError(cycle2);
		assertTrue(report.containsError(expectedError));
	}
	
	private static <E,S,F> F nestedDependencyCycle(IFormAlg<E,S,F> f, IStmtAlg<E,S> s, IExpAlg<E> e){
		List<S> level1 = new ArrayList<S>();
		List<S> level2 = new ArrayList<S>();
		List<S> level3 = new ArrayList<S>();
		
		level1.add(s.iff(e.var("X1"), s.block(level2)));
		level2.add(s.question("X2", "label 2", new TBoolean()));
		level2.add(s.iff(e.var("X2"), s.block(level3)));
		level3.add(s.question("X3", "label 3", new TBoolean()));
		level2 = new ArrayList<S>();
		
		level1.add(s.iff(e.var("X3"), s.block(level2)));
		level2.add(s.question("X1", "label 1", new TBoolean()));
		
		return f.form("Form id", level1);
	}
	
	@Test
	public void testBothDependenciesCycle() {
		IDetectCycle form = bothDependenciesCycle(new FormDependencies(), new StmtDependencies(), new ExprDependencies());

		form.detect(report);
		
		assertEquals(0, report.numberOfWarnings());
		
		assertEquals(3,report.numberOfErrors());
	}
	
	private static <E,S,F> F bothDependenciesCycle(IFormAlg<E,S,F> f, IStmtAlg<E,S> s, IExpAlg<E> e){
		List<S> level1 = new ArrayList<S>();
		List<S> level2 = new ArrayList<S>();
		List<S> level3 = new ArrayList<S>();
		
		level1.add(s.iff(e.var("X1"), s.block(level2)));
		level2.add(s.question("X2", "label 2", new TBoolean(), e.var("X3")));
		level2.add(s.iff(e.var("X2"), s.block(level3)));
		level3.add(s.question("X3", "label 3", new TBoolean()));
		level2 = new ArrayList<S>();
		
		level1.add(s.iff(e.var("X3"),s.block(level2)));
		level2.add( s.question("X4", "label 4", new TBoolean()));
		
		level1.add(s.question("X1", "label 5", new TBoolean(), e.var("X4")));		

		return f.form("Form id", level1);
	}
	

	
	@Test
	public void testDefinitionDependencyNoCycle() {
		IDetectCycle form = definitionNoCycle(new FormDependencies(), new StmtDependencies(), new ExprDependencies());

		form.detect(report);
		
		assertEquals(0, report.numberOfWarnings());
		
		assertEquals(0,report.numberOfErrors());
	}
	
	private static <E,S,F> F definitionNoCycle(IFormAlg<E,S,F> f, IStmtAlg<E,S> s, IExpAlg<E> e){
		List<S> level1 = new ArrayList<S>();
		List<S> level2 = new ArrayList<S>();
		
		level1.add(s.iff(e.var("X"), s.block(level2)));
		level2.add(s.question("Y", "label y", new TBoolean()));	
		level2 = new ArrayList<S>();
		
		level1.add(s.iff(e.var("Y"), s.block(level2)));
		level2.add(s.question("X", "label x", new TBoolean()));
		
		level1.add(s.question("X", "label z", new TBoolean()));
		
		return f.form("Form id", level1);
	}
	
	@Test
	public void testValueDependencyNoCycle() {
		IDetectCycle form = valueDependencyNoCycle(new FormDependencies(), new StmtDependencies(), new ExprDependencies());

		form.detect(report);
		
		assertEquals(0, report.numberOfWarnings());
		
		assertEquals(0,report.numberOfErrors());
	}
	
	private static <E,S,F> F valueDependencyNoCycle(IFormAlg<E,S,F> f, IStmtAlg<E,S> s, IExpAlg<E> e){
		List<S> level1 = new ArrayList<S>();
		level1.add(s.question("id", "label", new TBoolean(), e.var("undefined")));
		return f.form("Form id", level1);
	}	
	
	@Test
	public void testIndependent(){
		IDetectCycle form = independent(new FormDependencies(), new StmtDependencies(), new ExprDependencies());

		form.detect(report);
		
		assertEquals(0, report.numberOfWarnings());
		
		assertEquals(0,report.numberOfErrors());
	}
	
	private static <E,S,F> F independent(IFormAlg<E,S,F> f, IStmtAlg<E,S> s, IExpAlg<E> e){
		List<S> level1 = new ArrayList<S>();
		List<S> level2 = new ArrayList<S>();
		List<S> level3 = new ArrayList<S>();
		
		level1.add(s.iff(e.var("X1"), s.block(level2)));
		level2.add(s.question("X2", "label2", new TBoolean(), e.var("X1")));
		level2.add(s.iff(e.var("X2"), s.block(level3)));
		level3.add(s.question("X3", "label3", new TBoolean()));
		level2 = new ArrayList<S>();
		
		level1.add(s.iff(e.var("X3"),s.block(level2)));
		level2.add( s.question("X4", "label4", new TBoolean()));

		return f.form("Form id", level1);
	}

}
