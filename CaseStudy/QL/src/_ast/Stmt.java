package _ast;

import java.util.Map;
import java.util.Set;

import library.Pair;
import monoids.MapMonoid;
import monoids.SetMonoid;
import ql_obj_alg.check.types.Type;
import ql_obj_alg.syntax.IExpAlg;
import ql_obj_alg.syntax.IStmtAlg;

public abstract class Stmt {
	
	public static MapMonoid<String, Type> typeEnvMonoid = new MapMonoid<>();
	public static SetMonoid<Pair<String, String>> depMonoid = new SetMonoid<>();
	
	public abstract Stmt rename(Map<String, String> ren);
	public abstract Map<String,Type> typeEnv();
	public abstract Set<Pair<String,String>> controlDeps();
	public abstract <E, S> S recons(IExpAlg<E> expAlg, IStmtAlg<E, S> stmtAlg);
	public abstract int count();
	public abstract Stmt flatten(Exp guard);
}
