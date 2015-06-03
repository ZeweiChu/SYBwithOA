package ql_obj_alg.format;

import ql_obj_alg.syntax.IExpAlg;

public class ExprPrecedence implements IExpAlg<IPrecedence>{

	//Operator precedence: http://introcs.cs.princeton.edu/java/11precedence/
	@Override
	public IPrecedence lit(int x) {
		return getPrecedence(1);
	}

	@Override
	public IPrecedence bool(boolean b) {
		return getPrecedence(1);
	}

	@Override
	public IPrecedence string(String s) {
		return getPrecedence(1);
	}

	@Override
	public IPrecedence var(String varName) {
		return getPrecedence(1);
	}

	@Override
	public IPrecedence mul(IPrecedence lhs, IPrecedence rhs) {
		return getPrecedence(4);
	}

	@Override
	public IPrecedence div(IPrecedence lhs, IPrecedence rhs) {
		return getPrecedence(4);
	}

	@Override
	public IPrecedence add(IPrecedence lhs, IPrecedence rhs) {
		return getPrecedence(5);
	}

	@Override
	public IPrecedence sub(IPrecedence lhs, IPrecedence rhs) {
		return getPrecedence(5);
	}

	@Override
	public IPrecedence eq(IPrecedence lhs, IPrecedence rhs) {
		return getPrecedence(5);
	}

	@Override
	public IPrecedence neq(IPrecedence lhs, IPrecedence rhs) {
		return getPrecedence(8);
	}

	@Override
	public IPrecedence lt(IPrecedence lhs, IPrecedence rhs) {
		return getPrecedence(7);
	}

	@Override
	public IPrecedence leq(IPrecedence lhs, IPrecedence rhs) {
		return getPrecedence(7);
	}

	@Override
	public IPrecedence gt(IPrecedence lhs, IPrecedence rhs) {
		return getPrecedence(7);
	}

	@Override
	public IPrecedence geq(IPrecedence lhs, IPrecedence rhs) {
		return getPrecedence(7);
	}

	@Override
	public IPrecedence not(IPrecedence exp) {
		return getPrecedence(2);
	}

	@Override
	public IPrecedence and(IPrecedence lhs, IPrecedence rhs) {
		return getPrecedence(12);
	}

	@Override
	public IPrecedence or(IPrecedence lhs, IPrecedence rhs) {
		return getPrecedence(13);
	}

	public static IPrecedence getPrecedence(final int level){
		return new IPrecedence(){
			@Override
			public int prec() {
				return level;
			}	
		};
	}

	@Override
	public IPrecedence bracket(IPrecedence e) {
		return new IPrecedence() {
			
			@Override
			public int prec() {
				return 0;
			}
		};
	}
}
