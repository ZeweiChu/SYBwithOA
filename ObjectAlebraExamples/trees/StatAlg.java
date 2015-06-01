package trees;

import com.zewei.annotation.processor.Algebra;

//BEGIN_STATALG
@Algebra
public interface StatAlg<Exp, Stat> {
	Stat Seq(Stat s1, Stat s2);
	Stat Assign(String x, Exp e);
}
//END_STATALG
