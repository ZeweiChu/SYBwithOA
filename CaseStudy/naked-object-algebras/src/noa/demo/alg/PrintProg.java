package noa.demo.alg;

public class PrintProg implements ProgAlg<IPrint, IPrint> {
	@Override
	public IPrint start(IPrint e) {
		return new IPrint() {

			@Override
			public String print() {
				return e.print();
			}
		};
	}

}
