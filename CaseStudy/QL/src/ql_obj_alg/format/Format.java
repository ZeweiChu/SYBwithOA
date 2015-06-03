package ql_obj_alg.format;

import ql_obj_alg.box.BoxAlg;
import ql_obj_alg.box.FormatBox;
import ql_obj_alg.box.IFormat;
import ql_obj_alg.syntax.IAllAlg;
import ql_obj_alg.syntax.IExpAlg;

public class Format implements ExprFormat, StmtFormat, FormFormat, IAllAlg<IFormatWithPrecedence, IFormat, IFormat> {
	private final BoxAlg<IFormat> box = new FormatBox();
	private final IExpAlg<IPrecedence> prec = new ExprPrecedence();
	
	
	@Override
	public BoxAlg<IFormat> box() {
		return box;
	}

	@Override
	public IExpAlg<IPrecedence> prec() {
		return prec;
	}

}
