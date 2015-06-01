package query;

import library.Monoid;
import trees.QLAlg;

public interface QLAlgQuery<R> extends QLAlg<R, R, R> {

	Monoid<R> m();

	default R Form(java.lang.String p0, java.util.List<R> p1) {
		R res = m().empty();
		res = m().join(res, m().fold(p1));
		return res;
	}

	default R GEq(R p0, R p1) {
		R res = m().empty();
		res = m().join(res, p0);
		res = m().join(res, p1);
		return res;
	}

	default R If(R p0, R p1) {
		R res = m().empty();
		res = m().join(res, p0);
		res = m().join(res, p1);
		return res;
	}

	default R Lit(int p0) {
		R res = m().empty();
		return res;
	}

	default R Question(java.lang.String p0, java.lang.String p1, java.lang.String p2) {
		R res = m().empty();
		return res;
	}

	default R Var(java.lang.String p0) {
		R res = m().empty();
		return res;
	}

}