package ql_obj_alg.format;

import java.util.List;

import ql_obj_alg.box.BoxAlg;
import ql_obj_alg.box.IFormat;
import ql_obj_alg.check.types.Type;
import ql_obj_alg.syntax.IStmtAlg;

public interface StmtFormat extends IStmtAlg<IFormatWithPrecedence, IFormat> {
	BoxAlg<IFormat> box();

	
	@Override
	default IFormat block(List<IFormat> stats) {
		return box().V(box().L("{"), box().I(2,stats), box().L("}"));
	}
	
	@Override
	default IFormat iff(final IFormatWithPrecedence cond, final IFormat then) {
		return box().H(box().H(1,box().L("if"),box().H(box().L("("),cond,box().L(")")), then));
	}

	
	
	@Override
	default IFormat iffelse(final IFormatWithPrecedence cond, IFormat then, IFormat els) {
		return box().V(box().H(1,box().L("if"),box().H(box().L("("),cond,box().L(")")), then),
					 box().H(1, box().L("else"), els));
	}

	@Override
	default IFormat question(final String id, final String label, final Type type) {
		return box().H(1,box().L(id),box().L("\"" + label + "\""),box().L(type.toString()));
	}

	@Override
	default IFormat question(final String id, final String label, final Type type,
			final IFormatWithPrecedence exp) {
		return 	box().H(1,box().L(id),box().L("\"" + label + "\""),box().L(type.toString()), box().L("="), box().H(0, box().L("("), exp, box().L(")")));
	}

}
