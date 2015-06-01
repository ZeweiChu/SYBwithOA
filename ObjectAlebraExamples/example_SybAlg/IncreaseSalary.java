package example_SybAlg;

import trees.OneOhOneAlg;
import util.OneOhOneAlgTrans;

//BEGIN_TRANSFORM_WITH_OAFRAMEWORK
class IncreaseSalary<C,D,U,E,P,S> extends OneOhOneAlgTrans<C,D,U,E,P,S> {
	IncreaseSalary(OneOhOneAlg<C,D,U,E,P,S> alg) { super(alg); }
	public S S(float salary) { return oneOhOneAlg().S(1.1f * salary); }
}
//END_TRANSFORM_WITH_OAFRAMEWORK
