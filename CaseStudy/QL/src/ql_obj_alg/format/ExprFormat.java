package ql_obj_alg.format;

import java.io.StringWriter;

import ql_obj_alg.box.BoxAlg;
import ql_obj_alg.box.IFormat;
import ql_obj_alg.syntax.IExpAlg;

public interface ExprFormat extends IExpAlg<IFormatWithPrecedence> {

	BoxAlg<IFormat> box();
	IExpAlg<IPrecedence> prec();


	public static class FP implements IFormatWithPrecedence {
		private IFormat f;
		private IPrecedence p;

		public FP(IFormat f, IPrecedence p) {
			this.f = f;
			this.p = p;
		}

		@Override
		public void format(int indent, boolean vert, StringWriter writer) {
			f.format(indent, vert, writer);
		}
		
		@Override
		public int prec() {
			return p.prec();
		}
	}
	
	static IFormat binary(BoxAlg<IFormat> box, IFormatWithPrecedence l, IFormatWithPrecedence r, 
			String op, IPrecedence myPrec) {
		return box.H(1,parens(box, myPrec, l), box.L(op), parens(box, myPrec, r));
	}
	
	static IFormat unary(BoxAlg<IFormat> box, IFormatWithPrecedence l, String op, IPrecedence myPrec) {
		return box.H(0,box.L(op), parens(box, myPrec, l));
	}


	static  IFormat parens(BoxAlg<IFormat> box, IPrecedence parent, IFormatWithPrecedence kid) {
		if (kid.prec() > parent.prec()) {
			return box.H(box.L("("), kid, box.L(")"));
		}
		return kid;
	}

	@Override
	default IFormatWithPrecedence lit(int x) {
		return new FP(box().L(""+x),prec().lit(x));
	}


	@Override
	default IFormatWithPrecedence bool(boolean b) {
		return new FP(box().L(""+b),prec().bool(b));
	}


	@Override
	default IFormatWithPrecedence string(String s) {
		return new FP(box().L(s),prec().string(s));
	}


	@Override
	default IFormatWithPrecedence var(String varName) {
		return new FP(box().L(varName),prec().string(varName));
	}


	@Override
	default IFormatWithPrecedence mul(IFormatWithPrecedence lhs,
			IFormatWithPrecedence rhs) {
		IPrecedence myPrec = prec().mul(lhs, rhs);
		return new FP(binary(box(), lhs,rhs,"*",myPrec),myPrec);
	}


	@Override
	default IFormatWithPrecedence div(IFormatWithPrecedence lhs,
			IFormatWithPrecedence rhs) {
		IPrecedence myPrec = prec().div(lhs, rhs);
		return new FP(binary(box(), lhs,rhs,"/",myPrec),myPrec);
	}


	@Override
	default IFormatWithPrecedence add(IFormatWithPrecedence lhs,
			IFormatWithPrecedence rhs) {
		IPrecedence myPrec = prec().add(lhs, rhs);
		return new FP(binary(box(), lhs,rhs,"+",myPrec),myPrec);
	}


	@Override
	default IFormatWithPrecedence sub(IFormatWithPrecedence lhs,
			IFormatWithPrecedence rhs) {
		IPrecedence myPrec = prec().sub(lhs, rhs);
		return new FP(binary(box(), lhs,rhs,"-",myPrec),myPrec);
	}


	@Override
	default IFormatWithPrecedence eq(IFormatWithPrecedence lhs,
			IFormatWithPrecedence rhs) {
		IPrecedence myPrec = prec().eq(lhs, rhs);
		return new FP(binary(box(), lhs,rhs,"==",myPrec),myPrec);
	}


	@Override
	default IFormatWithPrecedence neq(IFormatWithPrecedence lhs,
			IFormatWithPrecedence rhs) {
		IPrecedence myPrec = prec().neq(lhs, rhs);
		return new FP(binary(box(), lhs,rhs,"!=",myPrec),myPrec);
	}


	@Override
	default IFormatWithPrecedence lt(IFormatWithPrecedence lhs,
			IFormatWithPrecedence rhs) {
		IPrecedence myPrec = prec().lt(lhs, rhs);
		return new FP(binary(box(), lhs,rhs,"<",myPrec),myPrec);
	}


	@Override
	default IFormatWithPrecedence leq(IFormatWithPrecedence lhs,
			IFormatWithPrecedence rhs) {
		IPrecedence myPrec = prec().leq(lhs, rhs);
		return new FP(binary(box(), lhs,rhs,"<=",myPrec),myPrec);
	}


	@Override
	default IFormatWithPrecedence gt(IFormatWithPrecedence lhs,
			IFormatWithPrecedence rhs) {
		IPrecedence myPrec = prec().gt(lhs, rhs);
		return new FP(binary(box(), lhs,rhs,">",myPrec),myPrec);
	}


	@Override
	default IFormatWithPrecedence geq(IFormatWithPrecedence lhs,
			IFormatWithPrecedence rhs) {
		IPrecedence myPrec = prec().geq(lhs, rhs);
		return new FP(binary(box(), lhs,rhs,">=",myPrec),myPrec);
	}


	@Override
	default IFormatWithPrecedence not(IFormatWithPrecedence exp) {
		IPrecedence myPrec = prec().not(exp);
		return new FP(unary(box(), exp,"!",myPrec),myPrec);
	}


	@Override
	default IFormatWithPrecedence and(IFormatWithPrecedence lhs,
			IFormatWithPrecedence rhs) {
		IPrecedence myPrec = prec().and(lhs, rhs);
		return new FP(binary(box(), lhs,rhs,"&&",myPrec),myPrec);
	}


	@Override
	default IFormatWithPrecedence or(IFormatWithPrecedence lhs,
			IFormatWithPrecedence rhs) {
		IPrecedence myPrec = prec().mul(lhs, rhs);
		return new FP(binary(box(), lhs,rhs,"||",myPrec),myPrec);
	}

	@Override
	default IFormatWithPrecedence bracket(IFormatWithPrecedence e) {
		IPrecedence myPrec = prec().bracket(e);
		return new FP(box().H(box().L("("), e, box().L(")")), myPrec);
	};

}
