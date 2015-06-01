package lambAlgWithShy;

import java.util.function.Function;

//BEGIN_CONTEXT_TRANS_EXPALG
public interface G_ExpAlgTransform<A, B> extends ExpAlg<Function<A, B>> {
	ExpAlg<B> expAlg();
	default Function<A, B> Add(Function<A, B> p0, Function<A, B> p1) {
		return acc -> expAlg().Add(p0.apply(acc), p1.apply(acc));
	}
	default Function<A, B> Lit(int p0) {
		return acc -> expAlg().Lit(p0);
	}
	default Function<A, B> Var(String p0) {
		return acc -> expAlg().Var(p0);
	}
}
//END_CONTEXT_TRANS_EXPALG
