package ExpAlg.test_code.extensibility;

import transform.ExpAlgTransform;

interface Unique<E> extends ExpAlgTransform<E> {
	int nextInt();
	default E Var(String s) {
		return expAlg().Var(s + nextInt());
	}
}
