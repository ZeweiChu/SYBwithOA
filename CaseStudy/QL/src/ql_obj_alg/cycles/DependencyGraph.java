package ql_obj_alg.cycles;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DependencyGraph {
	private Map<String, VariableDependencies> varDependencies;

	public DependencyGraph() {
		this.varDependencies = new HashMap<String, VariableDependencies>();
	}

	public void addDefinitionDependecies(String var, Dependencies dependencies) {
		VariableDependencies vd = getNodeVariableDependencies(var);
		if (dependencies.isEmpty())
			vd.removeDefinitionDepedencies();
		else
			vd.addDefinitionDependencies(dependencies);
		varDependencies.put(var, vd);
	}

	public void addValueDependecies(String var, Dependencies currentDependencies) {
		VariableDependencies vd = getNodeVariableDependencies(var);
		vd.addValueDependencies(currentDependencies);
		varDependencies.put(var, vd);
	}

	public Dependencies getNodeDependencies(String var) {
		return getNodeVariableDependencies(var).getDependencies();
	}

	public Set<String> nodes() {
		return varDependencies.keySet();
	}

	private VariableDependencies getNodeVariableDependencies(String var) {
		VariableDependencies vd = varDependencies.get(var);
		if (vd == null) {
			vd = new VariableDependencies();
		}
		return vd;
	}
}
