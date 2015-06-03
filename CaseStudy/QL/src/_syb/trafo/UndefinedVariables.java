package _syb.trafo;

import java.util.Set;
import java.util.function.Function;

import ql_obj_alg.syntax.IFormAlg;

class Env {
	
}

public interface UndefinedVariables extends IFormAlg<Function<Env, Set<String>>, Function<Env,Set<String>>, Function<Env,Set<String>>> {

}
