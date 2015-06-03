package util;

import transform.IUnlessAlgTransform;
import ql_obj_alg.syntax.IUnlessAlg;

public class IUnlessAlgTrans<A0, A1> implements IUnlessAlgTransform<A0, A1> {

	private IUnlessAlg<A0, A1> alg;

	public IUnlessAlgTrans(IUnlessAlg<A0, A1> alg) {this.alg = alg;}

	public IUnlessAlg<A0, A1> iUnlessAlg() {return alg;}

}