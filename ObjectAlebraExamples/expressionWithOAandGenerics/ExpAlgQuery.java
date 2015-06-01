package expressionWithOAandGenerics;

//BEGIN_GENERIC_QUERY
interface ExpAlgQuery<Exp> extends ExpAlg<Exp> {
	Monoid<Exp> m();
	default Exp Var(String s) { return m().empty(); } 
	default Exp Lit(int i) { return m().empty(); } 
	default Exp Add(Exp e1, Exp e2) {
		return m().join(e1, e2);
	}
}
//END_GENERIC_QUERY
