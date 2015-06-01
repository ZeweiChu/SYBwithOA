package example_SybAlg;

import transform.OneOhOneAlgTransform;
import trees.OneOhOneAlg;

public class Rename implements OneOhOneAlgTransform<String, String, String, String, String, String> {
	private OneOhOneAlg<String, String, String, String, String, String> alg;
	public Rename(OneOhOneAlg<String, String, String, String, String, String> alg) {this.alg = alg;}
	public OneOhOneAlg<String, String, String, String, String, String> oneOhOneAlg() {return alg;}
	public String P(String name, String address) {return alg.P("_" + name, address);}
}
