package expressionWithShy;

import library.Monoid;

public class FreeVarsMonoid implements Monoid<String[]> {

	@Override
	public String[] empty() {
		return new String[]{};
	}

	@Override
	public String[] join(String[] s1, String[] s2) {
		int s1len = s1.length;
		int s2len = s2.length;
		String[] res = new String[s1len+s2len];
		System.arraycopy(s1, 0, res, 0, s1len);
		System.arraycopy(s2, 0, res, s1len, s2len);
		return res;
	}
	

}
