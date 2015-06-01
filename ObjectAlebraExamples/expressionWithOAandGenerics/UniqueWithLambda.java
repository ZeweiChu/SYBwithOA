package expressionWithOAandGenerics;

//BEGIN_EXTEND_UNIQUEVARS
interface UniqueWithLambda<E> extends Unique<E>, LamAlgTransform<E> {
	default E Lam(String x, E e) {
		return lamAlg().Lam(x + nextInt(), e);
	}
}
//END_EXTEND_UNIQUEVARS

