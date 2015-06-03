package _syb.trafo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Arrays;

import ql_obj_alg.box.IFormat;
import ql_obj_alg.check.types.TBoolean;
import ql_obj_alg.format.Format;
import ql_obj_alg.format.IFormatWithPrecedence;
import ql_obj_alg.format.UnlessFormat;
import ql_obj_alg.syntax.IExpAlg;
import ql_obj_alg.syntax.IFormAlg;
import ql_obj_alg.syntax.IStmtAlg;
import ql_obj_alg.syntax.IUnlessAlg;
import transform.IFormAlgTransform;

public class TestDesugarUnless {
	
	static class FormatWithUnless extends Format implements UnlessFormat {
		
	}
	
	static class Desugar implements DesugarUnless<IFormatWithPrecedence, IFormat>, IFormAlgTransform<IFormatWithPrecedence, IFormat, IFormat> {
		private FormatWithUnless algebra;

		public Desugar(FormatWithUnless f) {
			this.algebra = f;
		}
		@Override
		public IExpAlg<IFormatWithPrecedence> iExpAlg() {
			return algebra;
		}

		@Override
		public IUnlessAlg<IFormatWithPrecedence, IFormat> iUnlessAlg() {
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
//		Builder builder = TheParser.parse(new FileInputStream(
//				"resources/inputfiles/test.QL"));

		FormatWithUnless algebra = new FormatWithUnless();
		Desugar d = new Desugar(algebra);

		// Create unless, pp as if(!..).
		IFormat pp = d.form("bla", Arrays.asList(d.unless(d.lit(4), d.block(Arrays.asList(d.question("x", "X?", new TBoolean()))))));
		
		StringWriter w = new StringWriter();
		pp.format(0, true, w);
		System.out.println(w);
	}
}
