package _syb.trafo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringWriter;
import java.util.function.Function;

import noa.Builder;
import ql_obj_alg.box.IFormat;
import ql_obj_alg.format.Format;
import ql_obj_alg.format.IFormatWithPrecedence;
import ql_obj_alg.parse.TheParser;
import ql_obj_alg.syntax.IExpAlg;
import ql_obj_alg.syntax.IFormAlg;
import ql_obj_alg.syntax.IStmtAlg;


public class TestInlineConditions {

	public static class DoIt implements InlineConditions<IFormatWithPrecedence, IFormat, IFormat> {
		private Format format;
		
		public DoIt(Format f) {
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

		
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Builder builder = TheParser.parse(new FileInputStream(
				"resources/inputfiles/test.QL"));


		Format algebra = new Format();
		
		Function<IFormatWithPrecedence, IFormat> pp = builder.build(new DoIt(algebra));

		StringWriter w = new StringWriter();
		pp.apply(algebra.bool(true)).format(0, true, w);
		System.out.println(w);
	}
}
