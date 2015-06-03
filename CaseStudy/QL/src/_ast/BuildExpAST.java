package _ast;

import ql_obj_alg.syntax.IExpAlg;

public interface BuildExpAST extends IExpAlg<Exp> {

	@Override
	default Exp bracket(Exp e) {
		return new Bracket(e);
	}

	@Override
	default Exp lit(int x) {
		return new Lit(x);
	}

	@Override
	default Exp bool(boolean b) {
		return new Bool(b);
	}

	@Override
	default Exp string(String s) {
		return new Str(s);
	}

	@Override
	default Exp var(String varName) {
		return new Var(varName);
	}

	@Override
	default Exp not(Exp exp) {
		return new Not(exp);
	}

	@Override
	default Exp mul(Exp lhs, Exp rhs) {
		return new Mul(lhs, rhs);
	}

	@Override
	default Exp div(Exp lhs, Exp rhs) {
		return new Div(lhs, rhs);
	}

	@Override
	default Exp add(Exp lhs, Exp rhs) {
		return new Add(lhs, rhs);
	}

	@Override
	default Exp sub(Exp lhs, Exp rhs) {
		return new Sub(lhs, rhs);
	}

	@Override
	default Exp eq(Exp lhs, Exp rhs) {
		return new Eq(lhs, rhs);
	}

	@Override
	default Exp neq(Exp lhs, Exp rhs) {
		return new Neq(lhs, rhs);
	}

	@Override
	default Exp lt(Exp lhs, Exp rhs) {
		return new Lt(lhs, rhs);
	}

	@Override
	default Exp leq(Exp lhs, Exp rhs) {
		return new Leq(lhs, rhs);
	}

	@Override
	default Exp gt(Exp lhs, Exp rhs) {
		return new Gt(lhs, rhs);
	}

	@Override
	default Exp geq(Exp lhs, Exp rhs) {
		return new Geq(lhs, rhs);
	}

	@Override
	default Exp and(Exp lhs, Exp rhs) {
		return new And(lhs, rhs);
	}

	@Override
	default Exp or(Exp lhs, Exp rhs) {
		return new Or(lhs, rhs);
	}

}
