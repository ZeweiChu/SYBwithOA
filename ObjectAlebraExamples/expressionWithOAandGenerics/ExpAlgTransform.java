package expressionWithOAandGenerics;

//BEGIN_GENERIC_TRANSFORM
interface ExpAlgTransform<Exp> extends ExpAlg<Exp> {
	ExpAlg<Exp> expAlg();
	default Exp Var(String s) {
		return expAlg().Var(s);
	}
	default Exp Lit(int i) { return expAlg().Lit(i); }
	default Exp Add(Exp e1, Exp e2) {
		return expAlg().Add(e1, e2);
	}
}
//END_GENERIC_TRANSFORM
