package ql_obj_alg.cycles;

public class VariableDependencies {
	Dependencies definitionDependencies = new Dependencies();
	Dependencies valueDependencies = new Dependencies();

	public void removeDefinitionDepedencies() {
		definitionDependencies.setIndependent();
	}

	private boolean isAlreadyDefined() {
		return definitionDependencies.isIndependent();
	}

	private boolean hasAlreadyValue() {
		return valueDependencies.isEmpty();
	}

	public void addDefinitionDependencies(Dependencies dependencies) {
		if (!this.isAlreadyDefined()) {
			definitionDependencies.addAll(dependencies);
		}
	}

	public void addValueDependencies(Dependencies dependecies) {
		valueDependencies.addAll(dependecies);
	}

	public Dependencies getDependencies() {
		Dependencies dependencies = new Dependencies();
		if (!isAlreadyDefined())
			dependencies.addAll(definitionDependencies);
		if (!hasAlreadyValue())
			dependencies.addAll(valueDependencies);
		return dependencies;
	}
}
