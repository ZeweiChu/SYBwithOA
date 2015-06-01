package example_SybAlg;

import java.util.List;
import java.util.function.Function;

import transform.G_OneOhOneAlgTransform;
import trees.OneOhOneAlg;

public class Rename2 implements G_OneOhOneAlgTransform<String, String, String, String, String, String, String> {
	private OneOhOneAlg<String, String, String, String, String, String> alg;
	public Rename2(OneOhOneAlg<String, String, String, String, String, String> alg) {this.alg = alg;}
	public OneOhOneAlg<String, String, String, String, String, String> oneOhOneAlg() {return alg;}
	public Function<String, String> D(String name, Function<String, String> manager, List<Function<String, String>> subUnits) {
		return acc -> alg.D(name, manager.apply(name), substListOneOhOneAlg(subUnits, name));
	}
	public Function<String, String> P(String name, String address) {
		return acc -> alg.P(name + "(" + acc + ")", address);
	}
}
