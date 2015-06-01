package sybDemo2;

import java.util.List;

import trees.OneOhOneAlg;

public class IncreaseSalarySybAlg implements OneOhOneAlg<Float, Float, Float, Float, Float, Float> {

	public OneOhOneAlg<Float, Float, Float, Float, Float, Float> alg;

	public IncreaseSalarySybAlg(OneOhOneAlg<Float, Float, Float, Float, Float, Float> alg) { this.alg = alg; }
	
	@Override
	public Float C(List<Float> depts) {
		return alg.C(depts);
	}

	@Override
	public Float D(String name, Float manager, List<Float> subUnits) {
		return alg.D(name, manager, subUnits);
	}

	@Override
	public Float PU(Float employee) {
		return alg.PU(employee);
	}

	@Override
	public Float DU(Float dept) {
		return alg.DU(dept);
	}

	@Override
	public Float E(Float p, Float s) {
		return alg.E(p, s);
	}

	@Override
	public Float P(String name, String address) {
		return alg.P(name, address);
	}

	@Override
	public Float S(float salary) {
		return alg.S(salary*1.1f);
	}

}
