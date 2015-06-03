package _ast;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

public abstract class Const extends Exp {

	@Override
	public Exp rename(Map<String, String> ren) {
		return this;
	}
	
	@Override
	public Set<String> freeVars() {
		return Collections.emptySet();
	}
	
	@Override
	public int count() {
		return 1;
	}
}
