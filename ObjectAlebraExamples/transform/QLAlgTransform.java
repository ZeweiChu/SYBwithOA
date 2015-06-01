package transform;

import trees.QLAlg;

public interface QLAlgTransform<A0, A1, A2> extends QLAlg<A0, A1, A2> {

	QLAlg<A0, A1, A2> qLAlg();

	@Override
	default A2 Form(java.lang.String p0, java.util.List<A1> p1) {
		return qLAlg().Form(p0, p1);
	}

	@Override
	default A0 GEq(A0 p0, A0 p1) {
		return qLAlg().GEq(p0, p1);
	}

	@Override
	default A1 If(A0 p0, A1 p1) {
		return qLAlg().If(p0, p1);
	}

	@Override
	default A0 Lit(int p0) {
		return qLAlg().Lit(p0);
	}

	@Override
	default A1 Question(java.lang.String p0, java.lang.String p1, java.lang.String p2) {
		return qLAlg().Question(p0, p1, p2);
	}

	@Override
	default A0 Var(java.lang.String p0) {
		return qLAlg().Var(p0);
	}

}