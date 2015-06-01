package monoid;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import library.Monoid;

public class SetMonoid<X> implements Monoid<Set<X>> {

	@Override
	public Set<X> join(Set<X> x, Set<X> y) {
		Set<X> tmp = new HashSet<>(x);
		tmp.addAll(y);
		return tmp;
	}

	@Override
	public Set<X> empty() {
		return Collections.emptySet();
	}

}

/*
//BEGIN_SET_MONOID
class SetMonoid<X> implements Monoid<Set<X>> {
	public Set<X> empty() {
		return Collections.emptySet();
	}
	public Set<X> join(Set<X> x, Set<X> y) {
		Set<X> tmp = new HashSet<>(x);
		tmp.addAll(y);
		return tmp;
	}
}
//END_SET_MONOID
*/
