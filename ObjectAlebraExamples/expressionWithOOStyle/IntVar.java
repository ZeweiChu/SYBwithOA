package expressionWithOOStyle;

public class IntVar implements Exp{
	String s;
	public IntVar(String s){
		this.s = s;
	}
	@Override
	public Value query() {
		return new VInt(0);
	}
	
	//for subst
	@Override
	public Exp subst(String v, Exp e) {
		if (s.equals(v)) return e;
		else return this;
	}

}
