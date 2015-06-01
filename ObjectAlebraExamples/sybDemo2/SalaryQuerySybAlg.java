package sybDemo2;

import java.util.List;
import trees.OneOhOneAlg;

//BEGIN_QUERY_SALARY
public class SalaryQuerySybAlg implements OneOhOneAlg<Float,Float,Float,Float,Float,Float> {
	@Override
	public Float C(List<Float> depts){
		return depts.stream().reduce(0.0f, (x, y) -> x + y);
	}
	@Override
	public Float D(String name, Float manager, List<Float> subUnits){
		Float r = manager;
		for (Float f: subUnits) r += f;
		return r;
	}
	@Override
	public Float PU(Float employee){
		return employee;
	}
	@Override
	public Float DU(Float dept){
		return dept;
	}
	@Override
	public Float E(Float p, Float s){
		return p + s;
	}
	@Override
	public Float P(String name, String address){
		return 0f;
	}
	@Override
	public Float S(float salary){
		return salary;
	}
}
//END_QUERY_SALARY