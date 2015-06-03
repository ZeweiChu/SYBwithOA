package ql_obj_alg.test;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import ql_obj_alg.eval.ExprEvaluator;
import ql_obj_alg.eval.IDepsAndEvalE;
import ql_obj_alg.eval.ValueEnvironment;
import ql_obj_alg.eval.values.VInteger;
import ql_obj_alg.eval.values.VUndefined;
import ql_obj_alg.eval.values.Value;
import ql_obj_alg.syntax.IExpAlg;



public class ExprEvalTests {

	ExprEvaluator exprEval;
	ValueEnvironment valEnv;
	@Before
	public void SetUp(){
		exprEval = new ExprEvaluator() {};
		valEnv = new ValueEnvironment();
	}
	@Test
	public void TestSimpleAdditionEval(){
		IDepsAndEvalE eval = SimpleAddition(exprEval);
		Value v = eval.eval(valEnv);
		assertTrue(v.getInteger().equals(3));

	}
	private static <E> E SimpleAddition(IExpAlg<E> alg){
		//1+2
		return alg.add(alg.lit(1), alg.lit(2));
	}

	@Test
	public void TestDividedByZero(){
		IDepsAndEvalE eval = DividedByZero(exprEval);
		Value v = eval.eval(valEnv);
		assertTrue(v.eq(new VUndefined()).getBoolean());

	}	
	private static <E> E DividedByZero(IExpAlg<E> alg){
		//5:0
		return alg.div(alg.lit(5), alg.lit(0));
	}

	@Test
	public void TestAssociativityOfDoubleDispatch(){
		IDepsAndEvalE eval = Min(exprEval);
		Value v = eval.eval(valEnv);
		assertTrue(v.getInteger().equals(2));		
	}

	private static <E> E Min(IExpAlg<E> alg){
		return alg.sub(alg.lit(5), alg.lit(3));
	}


	@Test
	public void TestLookUpfromVarEnvironment(){
		valEnv.setQuestionValue("var1", new VInteger(5));
		IDepsAndEvalE eval = LookUp(exprEval);
		Value v = eval.eval(valEnv);
		assertTrue(v.getInteger().equals(0));		
	}

	private static <E> E LookUp(IExpAlg<E> alg){
		return alg.sub(alg.lit(5), alg.var("var1"));
	}

}
