package noa.demo;

import noa.Builder;
import noa.Injector;
import noa.Pair;
import noa.Union;
import noa.demo.alg.EvalExp;
import noa.demo.alg.EvalProg;
import noa.demo.alg.ExpAlg0;
import noa.demo.alg.IEval;
import noa.demo.alg.IPrint;
import noa.demo.alg.PrintExp;
import noa.demo.alg.PrintExpWithEval;
import noa.demo.alg.PrintProg;
import noa.demo.alg.PrintProgPair;
import noa.demo.alg.ProgAlg;
import noa.demo.syn.AllAlg;
import noa.demo.syn.DemoLexer;
import noa.demo.syn.DemoParser;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

public class Demo {
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <X> X parse(String s, AllAlg alg)  {
		DemoLexer lexer = new DemoLexer(new ANTLRInputStream(s));
	    CommonTokenStream tokens = new CommonTokenStream(lexer);
	    DemoParser parser = new DemoParser(tokens);
	    parser.setBuilder(alg);
		return (X) parser.prog()._prog;
	}

	private static void testBuilder(String src) {
		System.out.println("## Using builder");
		Builder builder = parse(src, Builder.builderBuilder(AllAlg.class));
		IEval eval = builder.build(Union.union(AllAlg.class, new EvalExp(), new EvalProg()));
		System.out.println("eval " + src + " = " + eval.eval());
		
		IPrint print = builder.build(Union.union(AllAlg.class, new PrintExp(), new PrintProg()));
		System.out.println("print " + src + " = " + print.print());
	}
	
	@SuppressWarnings("unchecked")
	private static void testInjector(String src) {
		ExpAlg0<Pair<IEval, IPrint>> expAlg = Injector.make(ExpAlg0.class, new EvalExp(), new PrintExpWithEval(), IEval.class, IPrint.class);
		ProgAlg<IPrint, Pair<IEval, IPrint>> progAlg = new PrintProgPair();
		Builder builder = parse(src, Builder.builderBuilder(AllAlg.class));
		IPrint printWithEval = builder.build(Union.union(AllAlg.class, expAlg, progAlg));
		System.out.println(printWithEval.print());
	}
	
	public static void main(String[] args) {
		testBuilder("1 + 2 * 3 ");
		testBuilder("avg(1,2,3)");
		testInjector("1 + 2 * 3 ");
		testInjector("avg(1 + 2, 2 * 3, 3 + 4)");
	}
}
