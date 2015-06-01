package combinator;

import java.util.ArrayList;
import java.util.List;
import library.Pair;
import trees.QLAlg;

public class CombineQLAlg<A0, A1, A2, B0, B1, B2>
	implements QLAlg<Pair<A0, B0>, Pair<A1, B1>, Pair<A2, B2>> {

	public QLAlg<A0, A1, A2> alg1;
	public QLAlg<B0, B1, B2> alg2;

	public CombineQLAlg(QLAlg<A0, A1, A2> _alg1, QLAlg<B0, B1, B2> _alg2) {
		alg1 = _alg1;
		alg2 = _alg2;
	}

	private <A, B> Pair<List<A>, List<B>> getPairList(List<Pair<A, B>> l) {
		List<A> l1 = (List<A>)new ArrayList<A>();
		List<B> l2 = (List<B>)new ArrayList<B>();
		for (Pair<A, B> element : l) {
			l1.add(element.a());
			l2.add(element.b());
		}
		return new Pair<List<A>, List<B>>(l1, l2);
	}

	public Pair<A2, B2> Form(java.lang.String p0, List<Pair<A1, B1>> p1) {
		return new Pair<A2, B2>(alg1.Form(p0, getPairList(p1).a()), alg2.Form(p0, getPairList(p1).b()));
	}

	public Pair<A0, B0> GEq(Pair<A0, B0> p0, Pair<A0, B0> p1) {
		return new Pair<A0, B0>(alg1.GEq(p0.a(), p1.a()), alg2.GEq(p0.b(), p1.b()));
	}

	public Pair<A1, B1> If(Pair<A0, B0> p0, Pair<A1, B1> p1) {
		return new Pair<A1, B1>(alg1.If(p0.a(), p1.a()), alg2.If(p0.b(), p1.b()));
	}

	public Pair<A0, B0> Lit(int p0) {
		return new Pair<A0, B0>(alg1.Lit(p0), alg2.Lit(p0));
	}

	public Pair<A1, B1> Question(java.lang.String p0, java.lang.String p1, java.lang.String p2) {
		return new Pair<A1, B1>(alg1.Question(p0, p1, p2), alg2.Question(p0, p1, p2));
	}

	public Pair<A0, B0> Var(java.lang.String p0) {
		return new Pair<A0, B0>(alg1.Var(p0), alg2.Var(p0));
	}

}