package _syb.trafo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.function.Function;

import ql_obj_alg.box.IFormat;
import ql_obj_alg.check.types.TBoolean;
import ql_obj_alg.format.Format;
import ql_obj_alg.format.IFormatWithPrecedence;
import ql_obj_alg.format.RepeatFormat;
import ql_obj_alg.syntax.IExpAlg;
import ql_obj_alg.syntax.IFormAlg;
import ql_obj_alg.syntax.IRepeatAlg;
import ql_obj_alg.syntax.IStmtAlg;

public class TestDesugarRepeat {
	
	static class FormatWithRepeat extends Format implements RepeatFormat {
		
	}
	
	static class Desugar implements DesugarRepeat<IFormatWithPrecedence, IFormat, IFormat> {
		private FormatWithRepeat algebra;

		public Desugar(FormatWithRepeat f) {
			this.algebra = f;
		}
		@Override
		public IExpAlg<IFormatWithPrecedence> iExpAlg() {
			return algebra;
		}

		@Override
		public IRepeatAlg<IFormat> iRepeatAlg() {
			return algebra;
		}

		@Override
		public IFormAlg<IFormatWithPrecedence, IFormat, IFormat> iFormAlg() {
			return algebra;
		}

		@Override
		public IStmtAlg<IFormatWithPrecedence, IFormat> iStmtAlg() {
			return algebra;
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException {

		FormatWithRepeat algebra = new FormatWithRepeat();
		Desugar d = new Desugar(algebra);

		Function<String, IFormat> pp = d.form("bla", Arrays.asList(
				d.repeat(2, d.block(Arrays.asList(
						d.repeat(3, d.question("y", "Y?", new TBoolean())),
						d.question("x", "X?", new TBoolean()))))));
		
		StringWriter w = new StringWriter();
		pp.apply("").format(0, true, w);
		System.out.println(w);
	}
}
