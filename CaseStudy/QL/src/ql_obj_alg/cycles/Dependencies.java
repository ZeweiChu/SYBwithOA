package ql_obj_alg.cycles;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Dependencies implements Iterable<String> {
	private Set<String> nodes;

	public Dependencies() {
		nodes = new HashSet<String>();
	}

	public void setIndependent() {
		nodes = null;
	}

	public boolean isIndependent() {
		return nodes == null;
	}

	public boolean isEmpty() {
		return nodes.isEmpty();
	}

	public void add(String node) {
		if (!isIndependent()) {
			nodes.add(node);
		}
	}

	public void addAll(Dependencies dependencies) {
		if (!isIndependent()) {
			for (String node : dependencies) {
				nodes.add(node);
			}
		}
	}

	@Override
	public Iterator<String> iterator() {
		if (!isIndependent()) {
			return nodes.iterator();
		}
		return new HashSet<String>().iterator();
	}
}
