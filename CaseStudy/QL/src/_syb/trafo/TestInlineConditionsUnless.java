package _syb.trafo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.function.Function;

import noa.Builder;
import ql_obj_alg.box.IFormat;
import ql_obj_alg.check.types.TBoolean;
import ql_obj_alg.format.Format;
import ql_obj_alg.format.IFormatWithPrecedence;
import ql_obj_alg.format.UnlessFormat;
import ql_obj_alg.parse.TheParser;
import ql_obj_alg.syntax.IExpAlg;
import ql_obj_alg.syntax.IFormAlg;
import ql_obj_alg.syntax.IStmtAlg;
import ql_obj_alg.syntax.IUnlessAlg;

public class TestInlineConditionsUnless {

	static class FormatWithUnless extends Format implements UnlessFormat {
		
	}
	
	public static class DoIt implements InlineConditions<IFormatWithPrecedence, IFormat, IFormat>, InlineConditionsUnless<IFormatWithPrecedence, IFormat> {
		private FormatWithUnless format;
		
		public DoIt(FormatWithUnless f) {
			this.format = f;
		}
		
		@Override
		public IFormAlg<IFormatWithPrecedence, IFormat, IFormat> iFormAlg() {
			return format;
		}

		@Override
		public IStmtAlg<IFormatWithPrecedence, IFormat> iStmtAlg() {
			return format;
		}


		@Override
		public IExpAlg<IFormatWithPrecedence> iExpAlg() {
			return format;
		}
		
		@Override
		public IUnlessAlg<IFormatWithPrecedence, IFormat> iUnlessAlg() {
			return format;
		}
		
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		FormatWithUnless algebra = new FormatWithUnless();
		
		DoIt d = new DoIt(algebra);
		Function<IFormatWithPrecedence, IFormat> pp = d.form("bla", Arrays.asList(d.unless(d.lit(4), d.block(Arrays.asList(d.question("x", "X?", new TBoolean()))))));
		
		StringWriter w = new StringWriter();
		pp.apply(algebra.bool(true)).format(0, true, w);
		System.out.println(w);
	}
}