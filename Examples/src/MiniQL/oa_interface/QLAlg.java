package MiniQL.oa_interface;

import java.util.List;
import com.zewei.annotation.processor.Algebra;

@Algebra
public interface QLAlg<E, S, F> {
	F Form(String name, List<S> body);
	S If(E cond, S then);
	S Question(String name,String label,String type);
	E Lit(int n);
	E Var(String x);
	E GEq(E lhs, E rhs);
}
