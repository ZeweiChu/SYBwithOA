package ql_obj_alg.format;

import ql_obj_alg.box.IFormat;
import ql_obj_alg.syntax.IRepeatAlg;

public interface RepeatFormat extends StmtFormat, IRepeatAlg<IFormat> {
	@Override
	default IFormat repeat(int n, IFormat body) {
		return box().V(box().H(1,box().L("repeat"),box().H(box().L("("),box().L("" + n),box().L(")")),body));
	}
}
