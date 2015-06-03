package ql_obj_alg.flatten;

import java.util.List;

public interface IFlatten<E, S> {
	void flatten(E guard, List<S> output);
}
