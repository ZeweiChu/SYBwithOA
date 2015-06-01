package trees;

import com.zewei.annotation.processor.Algebra;

@Algebra
public interface LamAlg<Exp> {
	Exp Lam(String x, Exp e);
	Exp Apply(Exp e1, Exp e2);
}
