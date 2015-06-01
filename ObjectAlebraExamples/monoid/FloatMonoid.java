package monoid;

import library.Monoid;

public class FloatMonoid implements Monoid<Float>{
	@Override
	public Float join(Float x, Float y){
		return x + y;
	}
    @Override
	public Float empty(){
		return 0f;
	}
}
