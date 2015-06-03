package _ast;

import java.util.Map;

import ql_obj_alg.check.types.Type;

public abstract class Conditional extends Stmt {
	protected final Exp cond;
	protected final Stmt then;

	public Conditional(Exp cond, Stmt then) {
		this.cond = cond;
		this.then = then;
	}

	@Override
	public Map<String, Type> typeEnv() {
		return then.typeEnv();
	}
	
}
