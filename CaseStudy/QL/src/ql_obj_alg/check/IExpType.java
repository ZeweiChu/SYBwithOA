package ql_obj_alg.check;

import ql_obj_alg.check.types.Type;

public interface IExpType {
	Type type(TypeEnvironment typeEnv, ErrorReporting report);
}
