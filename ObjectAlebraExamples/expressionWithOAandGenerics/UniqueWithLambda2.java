package expressionWithOAandGenerics;

import trees.LamAlg;

public interface UniqueWithLambda2<E, Alg extends ExpAlg<E> & LamAlg<E>> extends Unique<E>, LamAlgTransform<E> {	
	Alg expAlg();
	
	default E Lam(String x, E e) { return expAlg().Lam(x + "#" + nextInt(), e); }
}
