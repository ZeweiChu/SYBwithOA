package expressionWithOAandGenerics;

import trees.LamAlg;

public interface LamAlgQuery<R> extends LamAlg<R> {

	Monoid<R> m();

	default R Apply(R p0, R p1) {
		R res = m().empty();
		res = m().join(res, p0);
		res = m().join(res, p1);
		return res;
	}

	default R Lam(java.lang.String p0, R p1) {
		R res = m().empty();
		res = m().join(res, p1);
		return res;
	}

}