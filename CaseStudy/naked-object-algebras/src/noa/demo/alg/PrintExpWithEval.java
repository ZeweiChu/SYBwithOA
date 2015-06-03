package noa.demo.alg;

import java.util.List;
import java.util.function.Function;

public class PrintExpWithEval implements ExpAlg<Function<IEval, IPrint>, IPrint> {

	@Override
	public Function<IEval, IPrint> mul(IPrint l, IPrint r) {
		return (eval) -> {
			return new IPrint() {
				@Override
				public String print() {
					return "Eval: mul " + eval.eval() + "\n" + l.print() + r.print();
				}
			};
		};
	}

	@Override
	public Function<IEval, IPrint> add(IPrint l, IPrint r) {
		return (eval) -> {
			return new IPrint() {
				@Override
				public String print() {
					return "Eval: add " + eval.eval() + "\n" + l.print() + r.print();
				}
			};
		};
	}

	@Override
	public Function<IEval, IPrint> lit(int n) {
		return (eval) -> {
			return new IPrint() {
				@Override
				public String print() {
					return "Eval: lit " + eval.eval() + "\n";
				}
			};
		};
	}

	@Override
	public Function<IEval, IPrint> avg(List<IPrint> es) {
		return (eval) -> {
			return new IPrint() {
				@Override
				public String print() {
					String s = "Eval: avg " + eval.eval() + "\n";
					for (IPrint p: es) {
						s += p.print();
					}
					return s;
				}
			};
		};
	}

}
