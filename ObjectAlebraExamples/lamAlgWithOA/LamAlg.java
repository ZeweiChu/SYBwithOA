package lamAlgWithOA;

//BEGIN_LAM_ALG
public interface LamAlg<Exp> {
	Exp Lam(String x, Exp e);
	Exp App(Exp e1, Exp e2);
}
//END_LAM_ALG
