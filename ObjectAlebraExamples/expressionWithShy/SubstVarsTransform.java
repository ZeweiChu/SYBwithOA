package expressionWithShy;

import transform.ExpAlgTransform;
import trees.ExpAlg;

class SubstVarsTransform implements ExpAlgTransform<String[]> {	
	private String s1, s2;
	private ExpAlg<String[]> alg;
	public SubstVarsTransform(ExpAlg<String[]> alg, String s1, String s2) {
		this.alg = alg;
		this.s1 = s1;
		this.s2 = s2;
	}
	@Override
	public ExpAlg<String[]> expAlg() {return alg;}
	@Override
	public String[] Var(String p0) {
		if (p0.equals(s1)) return alg.Var(s2);
		return alg.Var(p0);
	}
}
