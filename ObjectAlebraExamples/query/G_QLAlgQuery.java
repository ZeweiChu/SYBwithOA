package query;

import library.Monoid;
import trees.QLAlg;

public interface G_QLAlgQuery<A0, A1, A2> extends QLAlg<A0, A1, A2> {

	Monoid<A0> mE();
	Monoid<A1> mS();
	Monoid<A2> mF();

	@Override
	default A2 Form(java.lang.String p0, java.util.List<A1> p1) {
		A2 res = mF().empty();
		return res;
	}

	@Override
	default A0 GEq(A0 p0, A0 p1) {
		A0 res = mE().empty();
		res = mE().join(res, p0);
		res = mE().join(res, p1);
		return res;
	}

	@Override
	default A1 If(A0 p0, A1 p1) {
		A1 res = mS().empty();
		res = mS().join(res, p1);
		return res;
	}

	@Override
	default A0 Lit(int p0) {
		A0 res = mE().empty();
		return res;
	}

	@Override
	default A1 Question(java.lang.String p0, java.lang.String p1, java.lang.String p2) {
		A1 res = mS().empty();
		return res;
	}

	@Override
	default A0 Var(java.lang.String p0) {
		A0 res = mE().empty();
		return res;
	}

}