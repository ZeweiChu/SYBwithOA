package monoid;

import library.Monoid;

public class StringMonoid implements Monoid<String>{
	@Override
	public String join(String x, String y){
		return x + " " + y;
	}
    @Override
	public String empty(){
		return "";
	}
}
