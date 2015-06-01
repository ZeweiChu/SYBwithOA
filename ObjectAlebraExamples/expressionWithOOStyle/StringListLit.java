package expressionWithOOStyle;

import java.util.ArrayList;

public class StringListLit implements Exp{
	int i;
	public StringListLit(int i){this.i = i;} 
	@Override
	public VStringList query() {
		return new VStringList(new ArrayList<String>());
	}
	
	//for subst
	@Override
	public Exp subst(String v, Exp e) {
		return this;
	}
}
