package ql_obj_alg.util;

import java.io.StringWriter;
import java.util.Iterator;

import noa.Builder;
import noa.Union;
import ql_obj_alg.box.IFormat;
import ql_obj_alg.format.ExprFormat;
import ql_obj_alg.format.ExprPrecedence;
import ql_obj_alg.format.FormFormat;
import ql_obj_alg.format.Format;
import ql_obj_alg.format.StmtFormat;
import ql_obj_alg.parse.TheParser;
import ql_obj_alg.syntax.IAllAlg;

public class GenerateBinarySearchForm implements Iterable<String> {
	
	private final int min;
	private final int max;
	private final int step;

	public GenerateBinarySearchForm(int min, int max, int step) {
		this.min = min;
		this.max = max;
		this.step = step;
	}
	

	@Override
	public Iterator<String> iterator() {
		return new Iterator<String>() {
			int cur = min;

			@Override
			public boolean hasNext() {
				return cur + step <= max;
			}

			@Override
			public String next() {
				cur += step;
				StringBuilder sb = new StringBuilder();
				binaryForm(sb, min, cur);
				return sb.toString();
			}
		};
	}
	
	
 	
	public static void main(String[] args) {
		GenerateBinarySearchForm gen = new GenerateBinarySearchForm(0, 1000, 10);
		for (String f: gen) {
			System.out.println(format(f));
		}
	}

	
	private static String format(String s) {
		Builder builder = TheParser.parse(s);
		StringWriter w = new StringWriter();
		IFormat printingForm = builder.build(new Format());
		printingForm.format(0, false, w);
		return w.toString();
	}
	public void binaryForm(StringBuilder sb, int min, int max) {
		sb.append("form binary {\n  ");
		binaryFormRec(sb, min, max);
		sb.append("\n}");
	}

	private void binaryFormRec(StringBuilder sb, int min, int max) {
		if (max - min <= 1) {
			sb.append("answer_" + min + "_" + max + ": \"The answer is\" integer = (" + min + ")\n");
		}
		else {
			int half = min + ((max - min) / 2);
			String x = "x_" + min + "_" + half;
			sb.append(x + ": \"Is the number between " + min + " and " + half + "?\" boolean\n");
			sb.append("if (" + x + ") {\n");
			binaryFormRec(sb, min, half);
			sb.append("}\n");
			sb.append("else {\n");
			binaryFormRec(sb, half, max);
			sb.append("}\n");
		}
		
	}



}
