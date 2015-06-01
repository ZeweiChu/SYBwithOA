package ExpAlg.oa_interface;

import com.zewei.annotation.processor.Algebra;

@Algebra
public interface StatAlg<Exp, Stat> {
	Stat Seq(Stat s1, Stat s2);
	Stat Assign(String x, Exp e);
}
