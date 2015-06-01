package expressionWithOAandGenerics;

import java.util.Set;

import trees.LamAlg;

public class TestUniqueWithLambda {

	static class Unique<E> implements UniqueWithLambda<E> {
		private int count = 0;
		private final ExpAlg<E> expAlg;
		private final LamAlg<E> lamAlg;
		
		public <Alg extends ExpAlg<E> & LamAlg<E>> Unique(Alg alg) {
			this.expAlg = alg;
			this.lamAlg = alg;
		}
		
		@Override
		public int nextInt() {
			return count++;
		}

		@Override
		public ExpAlg<E> expAlg() {
			return expAlg;
		}

		
		@Override
		public LamAlg<E> lamAlg() {
			return lamAlg;
		}
		
	}
	
	public static void main(String[] args) {
		Unique<Set<String>> unq = new Unique<>(new FreeVarsWithLambdas.FreeVarsWithLambda() {
			@Override
			public Monoid<Set<String>> m() {
				return new SetMonoid<>();
			}
		});
		Set<String> term = unq.Lam("x", unq.Add(unq.Var("x"), unq.Var("y")));
		System.out.println(term);
	}
}
