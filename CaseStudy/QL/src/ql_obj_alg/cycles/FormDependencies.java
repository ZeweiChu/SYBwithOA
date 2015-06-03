package ql_obj_alg.cycles;

import java.util.List;

import ql_obj_alg.check.ErrorReporting;
import ql_obj_alg.check.errors.CyclicDependencyError;
import ql_obj_alg.syntax.IFormAlg;

public class FormDependencies implements
		IFormAlg<IExpDependency, IDependencyGraph, IDetectCycle> {

	@Override
	public IDetectCycle form(final String id,
			final List<IDependencyGraph> statements) {
		return new IDetectCycle() {

			@Override
			public void detect(ErrorReporting report) {

				DependencyGraph dependencyGraph = new DependencyGraph();
				for (IDependencyGraph stmt : statements) {
					stmt.fill(dependencyGraph, new Dependencies());
				}

				CycleDetection cycleDetection = new CycleDetection(dependencyGraph);
				for (Cycle cycle : cycleDetection.detectCycles()) {
					report.addError(new CyclicDependencyError(cycle));
				}
			}
		};
	}
}
