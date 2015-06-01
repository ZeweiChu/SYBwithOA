package expressionWithOOStyle;

public class IntAdd implements Exp{
	Exp left, right;
	public IntAdd(Exp left, Exp right){
		this.left = left;
		this.right = right;
	}
	@Override
	public Value query() {
		return new VInt(left.query().getInt() + right.query().getInt());
	}
	
	//for subst
	@Override
	public Exp subst(String v, Exp e) {
		return new IntAdd(left.subst(v, e), right.subst(v, e));
	}

}
