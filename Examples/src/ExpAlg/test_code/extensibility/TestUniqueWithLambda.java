package ExpAlg.test_code.extensibility;

import java.util.Set;
import Utils.SetMonoid;
import library.Monoid;
import ExpAlg.oa_interface.ExpAlg;
import ExpAlg.oa_interface.LamAlg;

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
	
	public Set<String> uniqueWithLambda() {
		Unique<Set<String>> unq = new Unique<>(new FreeVarsWithLambdas.FreeVarsWithLambda() {
			@Override
			public Monoid<Set<String>> m() {
				return new SetMonoid<>();
			}
		});
		return unq.Lam("x", unq.Add(unq.Var("x"), unq.Var("y")));
	}
	
}
