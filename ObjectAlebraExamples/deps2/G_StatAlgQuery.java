package deps2;

import library.Monoid;
import trees.StatAlg;

//BEGIN_GSTAT_QUERY
interface G_StatAlgQuery<Exp, Stat>
		extends StatAlg<Exp, Stat> {
	Monoid<Exp> mExp(); Monoid<Stat> mStat();
	default Stat Assign(String x, Exp e) {
		return mStat().empty();
	}
	default Stat Seq(Stat s1, Stat s2) {
		return mStat().join(s1, s2);
	}
}
//END_GSTAT_QUERY
