package example_SybAlg;

import trees.OneOhOneAlg;

import combinator.CombineOneOhOneAlg;

public class StringFloatQuery extends CombineOneOhOneAlg<String, String, String, String, String, String, Float, Float, Float, Float, Float, Float> {

	public StringFloatQuery(
			OneOhOneAlg<String, String, String, String, String, String> _alg1,
			OneOhOneAlg<Float, Float, Float, Float, Float, Float> _alg2) {
		super(_alg1, _alg2);
	}

}
