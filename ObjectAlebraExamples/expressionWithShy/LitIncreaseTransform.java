package expressionWithShy;

import transform.ExpAlgTransform;
import trees.ExpAlg;

class LitIncreaseTransform implements ExpAlgTransform<Integer> {
	private ExpAlg<Integer> alg;
	public LitIncreaseTransform(ExpAlg<Integer> alg) {this.alg = alg;}
	@Override
	public ExpAlg<Integer> expAlg() {return alg;}
	@Override
	public Integer Lit(int p0) {return alg.Lit(p0 * 2);}
}