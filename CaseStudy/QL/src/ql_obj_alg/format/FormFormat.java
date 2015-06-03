package ql_obj_alg.format;

import java.util.List;

import ql_obj_alg.box.BoxAlg;
import ql_obj_alg.box.IFormat;
import ql_obj_alg.syntax.IFormAlg;

public interface FormFormat extends IFormAlg<IFormatWithPrecedence,IFormat,IFormat>{

	BoxAlg<IFormat> box();
	
	@Override
	default IFormat form(final String id, final List<IFormat> statements) {
		return box().V(box().H(1,box().L("form"),box().L(id), box().L("{")),box().I(2,statements),box().L("}"));
	}
}
