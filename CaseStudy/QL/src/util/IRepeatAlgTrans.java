package util;

import transform.IRepeatAlgTransform;
import ql_obj_alg.syntax.IRepeatAlg;

public class IRepeatAlgTrans<A0> implements IRepeatAlgTransform<A0> {

	private IRepeatAlg<A0> alg;

	public IRepeatAlgTrans(IRepeatAlg<A0> alg) {this.alg = alg;}

	public IRepeatAlg<A0> iRepeatAlg() {return alg;}

}