package debruijn;

import static debruijn.Util.cons;

import java.util.List;
import java.util.function.Function;

import transform.G_ExpAlgTransform;
import transform.G_LamAlgTransform;

//BEGIN_DEBRUIJN
interface DeBruijn<E> extends
		G_ExpAlgTransform<List<String>, E>, 
		G_LamAlgTransform<List<String>, E> {
	default Function<List<String>, E> Var(String p0) {
		return xs ->
				expAlg().Var("" + (xs.indexOf(p0) + 1));
	}

	default Function<List<String>, E> Lam(String x, Function<List<String>, E> e) {
		return xs ->
				lamAlg().Lam("", e.apply(cons(x, xs)));
	}
}
//END_DEBRUIJN
