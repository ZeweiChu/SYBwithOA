package ql_obj_alg.parse;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import noa.Builder;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import ql_obj_alg.syntax.IAllAlg;

public class TheParser {
	
	public static Builder parse(String s) {
		try {
			return parse(new ByteArrayInputStream(s.getBytes("UTF-8")));
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	@SuppressWarnings("rawtypes")
	public static Builder parse(InputStream input) throws IOException {
		QLLexer lexer = new QLLexer(new ANTLRInputStream(input));
	    CommonTokenStream tokens = new CommonTokenStream(lexer);
	    QLParser qlParser = new QLParser(tokens);
	    IAllAlg builderBuilder = Builder.builderBuilder(IAllAlg.class);
	    qlParser.setBuilder(builderBuilder);
		return (Builder) qlParser.form()._form;
	}
	
	@SuppressWarnings("rawtypes")
	public static <E, S, F> Builder parse(InputStream input, IAllAlg<E, S, F> alg) throws IOException {
		QLLexer lexer = new QLLexer(new ANTLRInputStream(input));
	    CommonTokenStream tokens = new CommonTokenStream(lexer);
	    QLParser qlParser = new QLParser(tokens);
	    IAllAlg builderBuilder = Builder.builderBuilder(IAllAlg.class);
	    qlParser.setBuilder(builderBuilder);
		return (Builder) qlParser.form()._form;
	}
	
	@SuppressWarnings({"unchecked" })
	public static <E, S, F> F parse2(InputStream input, IAllAlg<E, S, F> alg) throws IOException {
		QLLexer lexer = new QLLexer(new ANTLRInputStream(input));
	    CommonTokenStream tokens = new CommonTokenStream(lexer);
	    QLParser qlParser = new QLParser(tokens);
	    qlParser.setBuilder(alg);
		return (F) qlParser.form()._form;
	}
	
	public static <E, S, F> F parse2(String s, IAllAlg<E, S, F> alg) {
		try {
			return parse2(new ByteArrayInputStream(s.getBytes("UTF-8")), alg);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
