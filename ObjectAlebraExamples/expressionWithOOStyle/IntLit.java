package expressionWithOOStyle;

public class IntLit implements Exp{
	int x;
	public IntLit(int x){this.x = x;}
	@Override
	public Value query() {
		return new VInt(x);
	}
	
	//for subst
	@Override
	public Exp subst(String v, Exp e) {
		return this;
	}
	
}
