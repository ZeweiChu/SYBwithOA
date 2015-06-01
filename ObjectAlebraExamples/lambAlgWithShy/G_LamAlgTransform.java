package lambAlgWithShy;

import java.util.function.Function;

//BEGIN_CONTEXT_TRANS_LAMALG
public interface G_LamAlgTransform<A, B> extends LamAlg<Function<A, B>> {
	LamAlg<B> lamAlg();
	default Function<A, B> Lam(String p0, Function<A, B> p1) {
		return acc -> lamAlg().Lam(p0, p1.apply(acc));
	}
	default Function<A, B> App(Function<A, B> p0, Function<A, B> p1) {
		return acc -> lamAlg().App(p0.apply(acc), p1.apply(acc));
	}
}
//END_CONTEXT_TRANS_LAMALG
