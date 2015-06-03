package ql_obj_alg.check;

import ql_obj_alg.check.types.Type;

public interface ICheck {
	boolean check(Type exp, TypeEnvironment env, ErrorReporting err);
}
