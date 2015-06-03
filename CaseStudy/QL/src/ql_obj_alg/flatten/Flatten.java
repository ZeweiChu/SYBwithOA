package ql_obj_alg.flatten;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import noa.Builder;
import ql_obj_alg.box.BoxAlg;
import ql_obj_alg.box.FormatBox;
import ql_obj_alg.box.IFormat;
import ql_obj_alg.check.types.Type;
import ql_obj_alg.format.ExprFormat;
import ql_obj_alg.format.ExprPrecedence;
import ql_obj_alg.format.Format;
import ql_obj_alg.format.IFormatWithPrecedence;
import ql_obj_alg.format.IPrecedence;
import ql_obj_alg.parse.TheParser;
import ql_obj_alg.syntax.IExpAlg;
import ql_obj_alg.syntax.IFormAlg;
import ql_obj_alg.syntax.IStmtAlg;
import ql_obj_alg.util.GenerateBinarySearchForm;

public class Flatten<E, S, F>  implements 
	IStmtAlg<E, IFlatten<E, S>>, IFormAlg<E, IFlatten<E, S>, F> {

	private IExpAlg<E> exp;
	private IStmtAlg<E, S> stmt;
	private IFormAlg<E, S, F> form;

	// a little clunky here, but ok.
	static class FlattenFormat extends Flatten<IFormatWithPrecedence, IFormat, IFormat> implements ExprFormat {
		
		public FlattenFormat(IExpAlg<IFormatWithPrecedence> exp, IStmtAlg<IFormatWithPrecedence, IFormat> stmt,
				IFormAlg<IFormatWithPrecedence, IFormat, IFormat> form) {
			super(exp, stmt, form);
		}

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
	
	public static void main(String[] args) {
		GenerateBinarySearchForm gen = new GenerateBinarySearchForm(1, 10, 9);
		Format format = new Format();
		FlattenFormat flatten = new FlattenFormat(format, format, format);
		for (String src: gen) {
			Builder build = TheParser.parse(src);
			IFormat f = build.build(flatten);
			StringWriter writer = new StringWriter();
			f.format(0, false, writer);
			System.out.println(writer.toString());
			break;
		}
	}
	
	public Flatten(IExpAlg<E> exp, IStmtAlg<E, S> stmt, IFormAlg<E, S, F> form) {
		this.exp = exp;
		this.stmt = stmt;
		this.form = form;
	}
	
	@Override
	public F form(String id, List<IFlatten<E, S>> statements) {
		List<S> ss = new ArrayList<S>();
		for (IFlatten<E, S> s: statements) {
			s.flatten(exp.bool(true), ss);
		}
		return form.form(id, ss);
	}

	
	@Override
	public IFlatten<E, S> block(List<IFlatten<E, S>> stats) {
		return (guard, output) -> {
			for (IFlatten<E,S> s: stats) {
				s.flatten(guard, output);
			}
		};
	}
	
	@Override
	public IFlatten<E, S> iff(E cond, IFlatten<E, S> statements) {
		return (guard, output) -> {
			statements.flatten(exp.and(guard, cond), output);
		};
	}

	@Override
	public IFlatten<E, S> iffelse(E cond, IFlatten<E, S> statementsIf, IFlatten<E, S> statementsElse) {
		return new IFlatten<E, S>() {
			@Override
			public void flatten(E guard, List<S> output) {
				statementsIf.flatten(exp.and(guard, cond), output);
				statementsElse.flatten(exp.and(guard, exp.not(cond)), output);
			}
		};
	}

	@Override
	public IFlatten<E, S> question(String id, String label, Type type) {
		return (guard, output) -> { output.add(stmt.iff(guard, stmt.question(id, label, type))); };
	}

	@Override
	public IFlatten<E, S> question(String id, String label, Type type, E exp) {
		return new IFlatten<E, S>() {

			@Override
			public void flatten(E guard, List<S> output) {
				output.add(stmt.iff(guard, stmt.question(id, label, type, exp)));
			}
			
		};
	}

}
