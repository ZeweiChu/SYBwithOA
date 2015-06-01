package transform;

import java.util.function.Function;
import java.util.List;
import java.util.ArrayList;
import trees.QLAlg;

public interface G_QLAlgTransform<A, B0, B1, B2> extends QLAlg<Function<A, B0>, Function<A, B1>, Function<A, B2>> {

	QLAlg<B0, B1, B2> qLAlg();

	default <B> List<B> substListQLAlg(List<Function<A, B>> list, A acc) {
		List<B> res = new ArrayList<B>();
		for (Function<A, B> i : list)
			res.add(i.apply(acc));
		return res;
	}

	@Override
	default Function<A, B2> Form(java.lang.String p0, List<Function<A, B1>> p1) {
		return acc -> qLAlg().Form(p0, substListQLAlg(p1, acc));
	}

	@Override
	default Function<A, B0> GEq(Function<A, B0> p0, Function<A, B0> p1) {
		return acc -> qLAlg().GEq(p0.apply(acc), p1.apply(acc));
	}

	@Override
	default Function<A, B1> If(Function<A, B0> p0, Function<A, B1> p1) {
		return acc -> qLAlg().If(p0.apply(acc), p1.apply(acc));
	}

	@Override
	default Function<A, B0> Lit(int p0) {
		return acc -> qLAlg().Lit(p0);
	}

	@Override
	default Function<A, B1> Question(java.lang.String p0, java.lang.String p1, java.lang.String p2) {
		return acc -> qLAlg().Question(p0, p1, p2);
	}

	@Override
	default Function<A, B0> Var(java.lang.String p0) {
		return acc -> qLAlg().Var(p0);
	}

}