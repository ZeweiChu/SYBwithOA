package monoids;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import library.Monoid;

public class ListMonoid<X> implements Monoid<List<X>> {

	@Override
	public List<X> join(List<X> x, List<X> y) {
		List<X> tmp = new ArrayList<X>(x);
		tmp.addAll(y);
		return tmp;
	}

	@Override
	public List<X> empty() {
		return Collections.emptyList();
	}

}
