package noa.demo.syn;

import noa.annos.Skip;
import noa.annos.Token;

public interface Tokens {
	@Token("[0-9]+")
	static int num(String src) {
		return Integer.parseInt(src);
	}
	
	@Token("[ ]+") @Skip
	void ws();
}
