package noa.demo.alg;

import java.util.List;

public class PrintExp implements ExpAlg0<IPrint> {

	@Override
	public IPrint add(IPrint l, IPrint r) {
		return new IPrint() {

			@Override
			public String print() {
				return l.print() + " + " + r.print();
			}
		};
	}

	@Override
	public IPrint lit(int n) {
		return new IPrint() {

			@Override
			public String print() {
				return "" + n;
			}
		};
	}

	@Override
	public IPrint avg(List<IPrint> es) {
		return new IPrint() {

			@Override
			public String print() {
				String s = "avg(";
				for (IPrint e : es) {
					s += e.print();
					s += ", ";
				}
				if (!s.equals("avg(")) {
					s = s.substring(0, s.length() - 2);
				}
				s += ")";
				return s;
			}
		};
	}

	@Override
	public IPrint mul(IPrint l, IPrint r) {
		return new IPrint() {

			@Override
			public String print() {
				return l.print() + " * " + r.print();
			}
		};
	}

}
