package noa.demo.alg;

public class EvalProg implements ProgAlg<IEval, IEval> {
	
	@Override
	public IEval start(IEval e) {
		return new IEval() {

			@Override
			public int eval() {
				return e.eval();
			}
		};
	}
}
