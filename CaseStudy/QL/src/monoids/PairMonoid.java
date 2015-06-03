package monoids;

import library.Monoid;
import library.Pair;

public class PairMonoid<A, B> implements Monoid<Pair<A, B>> {
	private final Monoid<A> a;
	private final Monoid<B> b;
	
	public PairMonoid(Monoid<A> a, Monoid<B> b) {
		this.a = a;
		this.b = b;
	}

	@Override
	public Pair<A, B> join(Pair<A, B> x, Pair<A, B> y) {
		return new Pair<>(a.join(x.a(), y.a()), b.join(x.b(), y.b()));
	}

	@Override
	public Pair<A, B> empty() {
		return new Pair<>(a.empty(), b.empty());
	}

}
