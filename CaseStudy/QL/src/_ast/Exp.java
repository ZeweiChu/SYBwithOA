package _ast;

import java.util.Map;
import java.util.Set;

import ql_obj_alg.syntax.IExpAlg;


public abstract class Exp {
	public abstract Exp rename(Map<String, String> ren);
	public abstract Set<String> freeVars();
	
	public abstract <E> E recons(IExpAlg<E> alg);
	public abstract int count();
}
