package ql_obj_alg.syntax;

import com.zewei.annotation.processor.Algebra;

@Algebra
public interface IRepeatAlg<S> {
	S repeat(int n, S body);
}
