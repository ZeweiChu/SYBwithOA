package expressionWithOAandGenerics;

//BEGIN_UNIQUEVARS
interface Unique<E> extends ExpAlgTransform<E> {
	int nextInt();
	default E Var(String s) {
		return expAlg().Var(s + nextInt());
	}
}
//END_UNIQUEVARS
