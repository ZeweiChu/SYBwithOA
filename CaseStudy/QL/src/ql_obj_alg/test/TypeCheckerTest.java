package ql_obj_alg.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import ql_obj_alg.check.CollectTypeEnv;
import ql_obj_alg.check.ErrorReporting;
import ql_obj_alg.check.ICollect;
import ql_obj_alg.check.ITypeCheck;
import ql_obj_alg.check.TypeChecker;
import ql_obj_alg.check.TypeEnvironment;
import ql_obj_alg.check.errors.ConflictingTypeError;
import ql_obj_alg.check.errors.GenError;
import ql_obj_alg.check.errors.UnexpectedTypeError;
import ql_obj_alg.check.errors.UnexpectedTypeInBinaryOpError;
import ql_obj_alg.check.types.TBoolean;
import ql_obj_alg.check.types.TInteger;
import ql_obj_alg.check.types.TNumber;
import ql_obj_alg.syntax.IExpAlg;
import ql_obj_alg.syntax.IFormAlg;
import ql_obj_alg.syntax.IStmtAlg;

public class TypeCheckerTest {
	
	ErrorReporting report;
	TypeEnvironment tenv;
	GenError expectedError;
	
	@Before
	public void setUp() throws Exception {
		report = new ErrorReporting();
		tenv = new TypeEnvironment();
		
		expectedError = null;
	}

	
	
	private static <E,S,F> F undefinedVariable(IFormAlg<E,S,F> f, IStmtAlg<E,S> s, IExpAlg<E> e){
		E exp = null;
		if(e != null)
			exp = e.var("undefined");
		
		List<S> questions = new ArrayList<S>();
		
		questions.add(s.question("id1", "label", new TBoolean(),exp));
		return f.form("Form id", questions);
	}
	
	@Test @Ignore
	public void testWrongTypeInAdd() {

		CollectTypeEnv coll = new CollectTypeEnv();
		TypeChecker tc = new TypeChecker();
		ICollect collector = wrongTypeInAdd(coll, coll,null);

		collector.collect(tenv,report);
		
		ITypeCheck form = wrongTypeInAdd(tc, tc, tc);
		form.check(tenv, report);

		assertEquals(0, report.numberOfWarnings());
				
		assertEquals(1,report.numberOfErrors());
		
		expectedError = new UnexpectedTypeInBinaryOpError(new TNumber(),new TInteger(),new TBoolean(),"+");
		
		assertTrue(report.containsError(expectedError));
	}
	
	private static <E,S,F> F wrongTypeInAdd(IFormAlg<E,S,F> f, IStmtAlg<E,S> s, IExpAlg<E> e){
		E exp = null;
		List<S> questions = new ArrayList<S>();
		questions.add(s.question("id1", "number", new TBoolean()));
		if(e != null)
			exp = e.add(e.lit(4), e.var("id1"));
		questions.add(s.question("id2", "textfield", new TInteger(), exp));
		
		return f.form("Form id", questions);
	}
	
	@Test @Ignore
	public void testIncompatibleTypeInEquals() {
		
		CollectTypeEnv coll = new CollectTypeEnv();
		TypeChecker tc = new TypeChecker();
		ICollect collector = incompatibleTypeInEquals(coll, coll, null);

		collector.collect(tenv,report);
		
		ITypeCheck form = incompatibleTypeInEquals(tc, tc, tc);
		form.check(tenv, report);

		assertEquals(0, report.numberOfWarnings());
				
		assertEquals(1,report.numberOfErrors());
		
		expectedError = new ConflictingTypeError(new TBoolean(), new TInteger(), "==");

		assertTrue(report.containsError(expectedError));
	}
	
	private static <E,S,F> F incompatibleTypeInEquals(IFormAlg<E,S,F> f, IStmtAlg<E,S> s, IExpAlg<E> e){
		E exp = null;
		if(e != null)
			exp = e.eq(e.bool(true), e.lit(4));
		
		List<S> questions = new ArrayList<S>();
		questions.add(s.question("id", "equals", new TBoolean(), exp));
		
		return f.form("Form id", questions);
	}
	
	@Test
	public void testWrongTypeInCondition() {
		CollectTypeEnv coll = new CollectTypeEnv();
		TypeChecker tc = new TypeChecker();
		ICollect collector = wrongTypeInCondition(coll, coll, null);

		collector.collect(tenv,report);
		
		ITypeCheck form = wrongTypeInCondition(tc, tc, tc);
		form.check(tenv, report);

		assertEquals(0, report.numberOfWarnings());
				
		assertEquals(1,report.numberOfErrors());
		
		expectedError = new UnexpectedTypeError(new TBoolean(),new TInteger(),"if-then");
		
		assertTrue(report.containsError(expectedError));
	}
	
	private static <E,S,F> F wrongTypeInCondition(IFormAlg<E,S,F> f, IStmtAlg<E,S> s, IExpAlg<E> e){
		E exp = null;
		if(e != null)
			exp = e.lit(4);
		List<S> stmtList = new ArrayList<S>();
		List<S> questions = new ArrayList<S>();
		
		questions.add( s.question("id1", "number", new TBoolean()));
		stmtList.add(s.iff(exp,s.block(questions)));		
		
		return f.form("Form id", stmtList);
	}
	
}
