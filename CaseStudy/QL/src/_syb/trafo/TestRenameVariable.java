package _syb.trafo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import noa.Builder;
import ql_obj_alg.box.IFormat;
import ql_obj_alg.format.Format;
import ql_obj_alg.format.IFormatWithPrecedence;
import ql_obj_alg.parse.TheParser;
import ql_obj_alg.syntax.IExpAlg;
import ql_obj_alg.syntax.IFormAlg;
import ql_obj_alg.syntax.IStmtAlg;
import transform.IFormAlgTransform;

public class TestRenameVariable {

	public static class DoIt implements RenameVariable<IFormatWithPrecedence, IFormat>, IFormAlgTransform<IFormatWithPrecedence, IFormat, IFormat> {
		private Map<String, String> renaming;
		private Format format;

		public DoIt(Map<String, String> renaming, Format format) {
			this.renaming = renaming;
			this.format = format;
		}
		
		public Map<String,String> renaming() {
			return renaming;
		}
		
		@Override
		public IExpAlg<IFormatWithPrecedence> iExpAlg() {
			return format;
		}

		@Override
		public IStmtAlg<IFormatWithPrecedence, IFormat> iStmtAlg() {
			return format;
		}

		@Override
		public IFormAlg<IFormatWithPrecedence, IFormat, IFormat> iFormAlg() {
			return format;
		}

	}
	
	
	@SuppressWarnings("serial")
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Builder builder = TheParser.parse(new FileInputStream(
				"resources/inputfiles/test.QL"));

		Map<String, String> ren = new HashMap<String, String>() {{
			put("privateDebt", "publicDebt");
			put("soldHouse", "didYouSellAHouse");
		}};

		Format algebra = new Format();
		
		IFormat pp = builder.build(new DoIt(ren, algebra));
		StringWriter w = new StringWriter();
		pp.format(0, true, w);
		System.out.println(w);
	}
}
