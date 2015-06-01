package expressionWithShy;

import library.Monoid;

public class LitMonoid implements Monoid<Integer> {
	
	@Override
	public Integer empty() {
		return 0;
	}

	@Override
	public Integer join(Integer e1, Integer e2) {
		return e1+e2;
	}
}
