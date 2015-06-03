package ql_obj_alg.format;

import ql_obj_alg.box.IFormat;
import ql_obj_alg.syntax.IUnlessAlg;

public interface UnlessFormat extends StmtFormat, IUnlessAlg<IFormatWithPrecedence, IFormat>{
	default IFormat unless(IFormatWithPrecedence cond, IFormat body) {
		return box().V(box().H(1,box().L("unless"),box().H(box().L("("),cond,box().L(")")), body));
	}
}
