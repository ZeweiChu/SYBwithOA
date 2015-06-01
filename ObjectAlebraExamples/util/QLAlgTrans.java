package util;

import transform.QLAlgTransform;
import trees.QLAlg;

public class QLAlgTrans<A0, A1, A2> implements QLAlgTransform<A0, A1, A2> {

	private QLAlg<A0, A1, A2> alg;

	public QLAlgTrans(QLAlg<A0, A1, A2> alg) {this.alg = alg;}

	public QLAlg<A0, A1, A2> qLAlg() {return alg;}

}