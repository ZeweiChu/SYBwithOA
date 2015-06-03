package ql_obj_alg.cycles;

import java.util.HashSet;
import java.util.Set;

public class CycleDetection {
	private DependencyGraph dependencyGraph;
	private Set<Cycle> cycles;
	private Set<String> visited;

	public CycleDetection(DependencyGraph dependencyGraph) {
		this.dependencyGraph = dependencyGraph;
	}

	public Set<Cycle> detectCycles() {
		visited = new HashSet<String>();
		cycles = new HashSet<Cycle>();
		for (String node : dependencyGraph.nodes()) {
			if (!visited.contains(node)) {
				visit(node, new Path());
			}
		}
		return cycles;
	}

	private void visit(String node, Path path) {
		if (path.contains(node)) {
			saveCycle(node, path);
			return;
		}

		if (visited.contains(node)) {
			return;
		}

		visited.add(node);
		Path newPath = new Path(path);
		newPath.moveOn(node);
		for (String edge : dependencyGraph.getNodeDependencies(node)) {
			visit(edge, newPath);
		}
	}

	private void saveCycle(String node, Path path) {
		cycles.add(path.extractCycle(node));
	}

	public void printCycles() {
		for (Cycle cycle : cycles) {
			System.out.println(cycle.toString());
		}
	}
}
