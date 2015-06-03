package ql_obj_alg.box;

import java.io.StringWriter;
import java.util.List;

public class FormatBox implements BoxAlg<IFormat> {
	
	private static void indent(int indent, StringWriter writer) {
		spaces(indent, writer);
	}

	private static void spaces(int n, StringWriter writer) {
		for (int i = 0; i < n; i++) {
			writer.append(" ");
		}
	}
	
	private static void newlines(int n, StringWriter writer) {
		for (int i = 0; i < n; i++) {
			writer.append("\n");
		}
	}

	@Override
	public IFormat H(final int hs, final List<IFormat> kids) {
		return new IFormat() {
			
			@Override
			public void format(int indent, boolean vert, StringWriter writer) {
				if (vert) {
					indent(indent, writer);
				}
				boolean first = true;
				for (IFormat kid: kids) {
					if (!first) {
						spaces(hs, writer);
					}
					kid.format(indent, false, writer);
					first = false;
				}
			}
		};
	}

	@Override
	public IFormat V(final int vs, final List<IFormat> kids) {
		return new IFormat() {
			
			@Override
			public void format(int indent, boolean vert, StringWriter writer) {
				boolean first = true;
				for (IFormat kid: kids) {
					if (!first) {
						newlines(vs, writer);	
					}
					kid.format(indent, true, writer);
					first = false;
				}
			}
		};
	}

	@Override
	public IFormat I(final int is, final int vs, final List<IFormat> kids) {
		final IFormat v = V(vs, kids);
		return new IFormat() {
			
			@Override
			public void format(int indent, boolean vert, StringWriter writer) {
				v.format(indent + is, true, writer);
			}
		};
	}

	@Override
	public IFormat L(final String txt) {
		return new IFormat() {
			
			@Override
			public void format(int indent, boolean vert, StringWriter writer) {
				if (vert) {
					indent(indent, writer);
				}
				writer.append(txt);
			}
		};
	}

}
