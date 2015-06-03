package ql_obj_alg.cycles;

import ql_obj_alg.syntax.IExpAlg;

public class ExprDependencies implements IExpAlg<IExpDependency> {

	@Override
	public IExpDependency lit(int x) {
		return new IExpDependency() {

			@Override
			public Dependencies dependency(Dependencies currentDependencies) {
				return currentDependencies;
			}
		};
	}

	@Override
	public IExpDependency bool(boolean b) {
		return new IExpDependency() {

			@Override
			public Dependencies dependency(Dependencies currentDependencies) {
				return currentDependencies;
			}
		};
	}

	@Override
	public IExpDependency string(String s) {
		return new IExpDependency() {

			@Override
			public Dependencies dependency(Dependencies currentDependencies) {
				return currentDependencies;
			}
		};
	}

	@Override
	public IExpDependency var(final String s) {
		return new IExpDependency() {

			@Override
			public Dependencies dependency(Dependencies currentDependencies) {
				Dependencies newDependencies = new Dependencies();
				newDependencies.addAll(currentDependencies);
				newDependencies.add(s);
				return newDependencies;
			}
		};
	}

	@Override
	public IExpDependency mul(final IExpDependency lhs, final IExpDependency rhs) {
		return new IExpDependency() {

			@Override
			public Dependencies dependency(Dependencies currentDependencies) {
				return unionDependencies(lhs, rhs, currentDependencies);
			}
		};
	}

	@Override
	public IExpDependency div(final IExpDependency lhs, final IExpDependency rhs) {
		return new IExpDependency() {

			@Override
			public Dependencies dependency(Dependencies currentDependencies) {
				return unionDependencies(lhs, rhs, currentDependencies);
			}
		};
	}

	@Override
	public IExpDependency add(final IExpDependency lhs, final IExpDependency rhs) {
		return new IExpDependency() {

			@Override
			public Dependencies dependency(Dependencies currentDependencies) {
				return unionDependencies(lhs, rhs, currentDependencies);
			}
		};
	}

	@Override
	public IExpDependency sub(final IExpDependency lhs, final IExpDependency rhs) {
		return new IExpDependency() {

			@Override
			public Dependencies dependency(Dependencies currentDependencies) {
				return unionDependencies(lhs, rhs, currentDependencies);
			}
		};
	}

	@Override
	public IExpDependency eq(final IExpDependency lhs, final IExpDependency rhs) {
		return new IExpDependency() {

			@Override
			public Dependencies dependency(Dependencies currentDependencies) {
				return unionDependencies(lhs, rhs, currentDependencies);
			}
		};
	}

	@Override
	public IExpDependency neq(final IExpDependency lhs, final IExpDependency rhs) {
		return new IExpDependency() {

			@Override
			public Dependencies dependency(Dependencies currentDependencies) {
				return unionDependencies(lhs, rhs, currentDependencies);
			}
		};
	}

	@Override
	public IExpDependency lt(final IExpDependency lhs, final IExpDependency rhs) {
		return new IExpDependency() {

			@Override
			public Dependencies dependency(Dependencies currentDependencies) {
				return unionDependencies(lhs, rhs, currentDependencies);
			}
		};
	}

	@Override
	public IExpDependency leq(final IExpDependency lhs, final IExpDependency rhs) {
		return new IExpDependency() {

			@Override
			public Dependencies dependency(Dependencies currentDependencies) {
				return unionDependencies(lhs, rhs, currentDependencies);
			}
		};
	}

	@Override
	public IExpDependency gt(final IExpDependency lhs, final IExpDependency rhs) {
		return new IExpDependency() {

			@Override
			public Dependencies dependency(Dependencies currentDependencies) {
				return unionDependencies(lhs, rhs, currentDependencies);
			}
		};
	}

	@Override
	public IExpDependency geq(final IExpDependency lhs, final IExpDependency rhs) {
		return new IExpDependency() {

			@Override
			public Dependencies dependency(Dependencies currentDependencies) {
				return unionDependencies(lhs, rhs, currentDependencies);
			}
		};
	}

	@Override
	public IExpDependency not(final IExpDependency exp) {
		return new IExpDependency() {

			@Override
			public Dependencies dependency(Dependencies currentDependencies) {
				Dependencies newDependencies = new Dependencies();
				newDependencies.addAll(exp.dependency(currentDependencies));
				return newDependencies;
			}
		};
	}

	@Override
	public IExpDependency and(final IExpDependency lhs, final IExpDependency rhs) {
		return new IExpDependency() {

			@Override
			public Dependencies dependency(Dependencies currentDependencies) {
				return unionDependencies(lhs, rhs, currentDependencies);
			}
		};
	}

	@Override
	public IExpDependency or(final IExpDependency lhs, final IExpDependency rhs) {
		return new IExpDependency() {

			@Override
			public Dependencies dependency(Dependencies currentDependencies) {
				return unionDependencies(lhs, rhs, currentDependencies);
			}
		};
	}

	@Override
	public IExpDependency bracket(IExpDependency e) {
		return new IExpDependency() {

			@Override
			public Dependencies dependency(Dependencies currentDependencies) {
				Dependencies newDependencies = new Dependencies();
				newDependencies.addAll(e.dependency(currentDependencies));
				return newDependencies;
			}

		};
	}

	public static Dependencies unionDependencies(final IExpDependency lhs,
			final IExpDependency rhs, Dependencies currentDependencies) {
		Dependencies newDependencies = new Dependencies();
		newDependencies.addAll(lhs.dependency(currentDependencies));
		newDependencies.addAll(rhs.dependency(currentDependencies));
		return newDependencies;
	}
}
