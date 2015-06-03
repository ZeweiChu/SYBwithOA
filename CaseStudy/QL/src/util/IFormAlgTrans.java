package util;

import transform.IFormAlgTransform;
import ql_obj_alg.syntax.IFormAlg;

public class IFormAlgTrans<A0, A1, A2> implements IFormAlgTransform<A0, A1, A2> {

	private IFormAlg<A0, A1, A2> alg;

	public IFormAlgTrans(IFormAlg<A0, A1, A2> alg) {this.alg = alg;}

	public IFormAlg<A0, A1, A2> iFormAlg() {return alg;}

}