package ql_obj_alg.cycles;

import java.util.LinkedList;
import java.util.List;

public class Cycle {
	private List<String> cycle = new LinkedList<String>();

	public void add(String node) {
		cycle.add(node);
	}

	public String toString() {
		assert (!cycle.isEmpty()) : "A cycle cannot be empty";
		StringBuffer output = new StringBuffer();
		for (String node : cycle) {
			output.append(node + " -> ");
		}
		output.append(cycle.get(0));
		return output.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		if (obj instanceof Cycle) {

			Cycle other = (Cycle) obj;

			if (this.cycle.size() != other.cycle.size()) {
				return false;
			}
			for (String node : this.cycle) {
				if (!other.cycle.contains(node)) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}
