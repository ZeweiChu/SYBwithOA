package noa.demo.alg;

import java.util.List;

public class EvalExp implements ExpAlg0<IEval> {

	@Override
	public IEval add(IEval l, IEval r) {
		return new IEval() {

			@Override
			public int eval() {
				return l.eval() + r.eval();
			}
		};
	}

	@Override
	public IEval lit(int n) {
		return new IEval() {

			@Override
			public int eval() {
				return n;
			}
		};
	}

	@Override
	public IEval avg(List<IEval> es) {
		return new IEval() {

			@Override
			public int eval() {
				int n = 0;
				int i = 0;
				for (IEval e : es) {
					n += e.eval();
					i++;
				}
				return n / i;
			}
		};
	}

	@Override
	public IEval mul(IEval l, IEval r) {
		return new IEval() {

			@Override
			public int eval() {
				return l.eval() * r.eval();
			}
		};
	}

}
