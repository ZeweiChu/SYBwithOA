package ExpAlg.test_code.transform.shy_approach;

import transform.ExpAlgTransform;

interface SubstVar<Exp>
		extends ExpAlgTransform<Exp> {
	String x(); Exp e();
	default Exp Var(String s) {
		return s.equals(x())? e(): expAlg().Var(s);
	}
}
