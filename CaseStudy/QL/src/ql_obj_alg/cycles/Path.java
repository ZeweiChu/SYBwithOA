package ql_obj_alg.cycles;

import java.util.ArrayList;

public class Path {
	ArrayList<String> path;

	public Path() {
		path = new ArrayList<String>();
	}

	public Path(Path path) {
		this.path = new ArrayList<String>(path.path);
	}

	public boolean contains(String node) {
		return path.contains(node);
	}

	public void moveOn(String node) {
		path.add(node);
	}

	public Cycle extractCycle(String starting) {
		Cycle cycle = new Cycle();
		for (int i = path.indexOf(starting); i < path.size(); i++) {
			cycle.add(path.get(i));
		}
		return cycle;
	}
}
