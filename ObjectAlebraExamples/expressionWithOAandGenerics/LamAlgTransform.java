package expressionWithOAandGenerics;

import trees.LamAlg;

public interface LamAlgTransform<A0> extends LamAlg<A0> {

	LamAlg<A0> lamAlg();

	@Override
	default A0 Apply(A0 p0, A0 p1) {
		return lamAlg().Apply(p0, p1);
	}

	@Override
	default A0 Lam(java.lang.String p0, A0 p1) {
		return lamAlg().Lam(p0, p1);
	}

}