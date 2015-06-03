package util;

import transform.IExpAlgTransform;
import ql_obj_alg.syntax.IExpAlg;

public class IExpAlgTrans<A0> implements IExpAlgTransform<A0> {

	private IExpAlg<A0> alg;

	public IExpAlgTrans(IExpAlg<A0> alg) {this.alg = alg;}

	public IExpAlg<A0> iExpAlg() {return alg;}

}