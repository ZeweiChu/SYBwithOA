package _syb.trans;

import ql_obj_alg.box.BoxAlg;
import ql_obj_alg.syntax.IExpAlg;

@SuppressWarnings("unchecked")
public interface ExpAlgDefaultToBox<E> extends IExpAlg<E> {
	BoxAlg<E> alg();

	@Override
	default E bracket(E e) {
		return e;
	}

	@Override
	default E lit(int x) {
		return alg().L("" + x);
	}

	@Override
	default E bool(boolean b) {
		return alg().L("" + b);
	}

	@Override
	default E string(String s) {
		return alg().L(s);
	}

	@Override
	default E var(String varName) {
		return alg().L(varName);
	}

	@Override
	default E not(E exp) {
		return exp;
	}

	@Override
	default E mul(E lhs, E rhs) {
		return alg().H(lhs, rhs);
	}

	@Override
	default E div(E lhs, E rhs) {
		return alg().H(lhs, rhs);
	}

	@Override
	default E add(E lhs, E rhs) {
		return alg().H(lhs, rhs);
	}

	@Override
	default E sub(E lhs, E rhs) {
		return alg().H(lhs, rhs);
	}

	@Override
	default E eq(E lhs, E rhs) {
		return alg().H(lhs, rhs);
	}

	@Override
	default E neq(E lhs, E rhs) {
		return alg().H(lhs, rhs);
	}

	@Override
	default E lt(E lhs, E rhs) {
		return alg().H(lhs, rhs);
	}

	@Override
	default E leq(E lhs, E rhs) {
		return alg().H(lhs, rhs);
	}

	@Override
	default E gt(E lhs, E rhs) {
		return alg().H(lhs, rhs);
	}

	@Override
	default E geq(E lhs, E rhs) {
		return alg().H(lhs, rhs);
	}

	@Override
	default E and(E lhs, E rhs) {
		return alg().H(lhs, rhs);
	}

	@Override
	default E or(E lhs, E rhs) {
		return alg().H(lhs, rhs);
	}

}
