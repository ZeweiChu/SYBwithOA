package expressionWithOA;

//BEGIN_SUBSTVARS_WITHOUT_ID
interface SubstVar<Exp> extends ExpAlg<Exp> {
	ExpAlg<Exp> expAlg();
	String x(); Exp e();
	default Exp Var(String s) {
		return s.equals(x())? e(): expAlg().Var(s);
	}
	default Exp Lit(int i) { return expAlg().Lit(i); }
	default Exp Add(Exp e1, Exp e2) {
		return expAlg().Add(e1, e2);
	}
}
//END_SUBSTVARS_WITHOUT_ID
