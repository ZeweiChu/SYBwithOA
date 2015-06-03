package monoids;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import library.Monoid;
import library.Pair;

public class GraphMonoid<T> implements Monoid<Triple<Set<T>, Set<Pair<T,T>>, Set<T>>> {

	@Override
	public Triple<Set<T>, Set<Pair<T, T>>, Set<T>> join(
			Triple<Set<T>, Set<Pair<T, T>>, Set<T>> x,
			Triple<Set<T>, Set<Pair<T, T>>, Set<T>> y) {
		Triple<Set<T>, Set<Pair<T,T>>, Set<T>> result = new Triple<>(new HashSet<>(), new HashSet<>(), new HashSet<>());

		result.a.addAll(x.a);
		result.b.addAll(x.b);
		result.b.addAll(y.b);
		result.c.addAll(y.c);
		
		for (T t1: x.c) {
			for (T t2: y.a) {
				result.b.add(new Pair<>(t1, t2));
			}
		}
		
		return result;
	}

	@Override
	public Triple<Set<T>, Set<Pair<T, T>>, Set<T>> empty() {
		return new Triple<>(Collections.emptySet(), Collections.emptySet(), Collections.emptySet());
	}


}
