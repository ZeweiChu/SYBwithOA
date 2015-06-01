package expressionWithOOStyle;

import java.util.ArrayList;
import java.util.List;

public class StringListAdd implements Exp{
	Exp left, right;
	public StringListAdd(Exp left, Exp right){
		this.left = left;
		this.right = right;
	}
	@Override
	public Value query() {
		List<String> ls = new ArrayList<String>();
		ls.addAll(left.query().getStringList());
		ls.addAll(right.query().getStringList());
		return new VStringList(ls);
	}
	
	//for subst
	@Override
	public Exp subst(String v, Exp e) {
		return new StringListAdd(left.subst(v, e), right.subst(v, e));
	}
}
