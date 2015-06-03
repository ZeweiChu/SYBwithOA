package util;

import transform.IStmtAlgTransform;
import ql_obj_alg.syntax.IStmtAlg;

public class IStmtAlgTrans<A0, A1> implements IStmtAlgTransform<A0, A1> {

	private IStmtAlg<A0, A1> alg;

	public IStmtAlgTrans(IStmtAlg<A0, A1> alg) {this.alg = alg;}

	public IStmtAlg<A0, A1> iStmtAlg() {return alg;}

}