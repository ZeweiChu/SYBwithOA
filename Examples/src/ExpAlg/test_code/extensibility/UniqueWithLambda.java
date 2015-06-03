package ExpAlg.test_code.extensibility;

import transform.LamAlgTransform;

interface UniqueWithLambda<E> extends Unique<E>, LamAlgTransform<E> {
	default E Lam(String x, E e) {
		return lamAlg().Lam(x + nextInt(), e);
	}
}

