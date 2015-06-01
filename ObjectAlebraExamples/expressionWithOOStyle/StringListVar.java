package expressionWithOOStyle;

import java.util.ArrayList;
import java.util.List;

public class StringListVar implements Exp{
	String x;
	public StringListVar(String x){this.x = x;}
	
	@Override
	public Value query() {
		List<String> ls = new ArrayList<String>();
		ls.add(x);
		return new VStringList(ls);
	}

	//for subst
	@Override
	public Exp subst(String v, Exp e) {
		if (x.equals(v)) return e;
		else return this;
	}
	
	

}
