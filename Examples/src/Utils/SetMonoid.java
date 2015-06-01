package Utils;

import static java.util.Collections.emptySet;
import java.util.Set;
import library.Monoid;
import static java.util.stream.Collectors.toSet;
import static java.util.stream.Stream.*;

public class SetMonoid<R> implements Monoid<Set<R>> {
	public Set<R> empty() {return emptySet();}
	public Set<R> join(Set<R> e1, Set<R> e2) {
		return concat(e1.stream(), e2.stream()).collect(toSet());
	}
}
