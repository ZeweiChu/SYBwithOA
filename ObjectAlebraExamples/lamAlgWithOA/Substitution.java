package lamAlgWithOA;

import java.util.Collections;
import java.util.HashMap;

//BEGIN_CAPTURE_AVOID_WITHOUT_ID
public interface Substitution<Exp> extends ExpAlg<Subst<Exp>>, LamAlg<Subst<Exp>> {	
	ExpAlg<Exp> expAlg();
	LamAlg<Exp> lamAlg();
	default Subst<Exp> Var(String s) {
		return (x, e, fv, ren) -> {
			String newS = s;
			if (ren.containsKey(s)) newS = ren.get(s);
			if (newS.equals(x)) return e;
			return expAlg().Var(newS);
		};
	}
	default Subst<Exp> Lit(int i) {
		return (x, e, fv, ren) -> expAlg().Lit(i);
	}
	default Subst<Exp> Add(Subst<Exp> e1, Subst<Exp> e2) {
		return (x, e, fv, ren) -> expAlg().Add(e1.subst(x, e, fv, ren), e2.subst(x, e, fv, ren));
	}
	default Subst<Exp> Lam(String x0, Subst<Exp> e0) {
		return (x, e, fv, ren) -> {
			if (x0.equals(x)) {
				return lamAlg().Lam(x0, e0.subst(x0, expAlg().Var(x0), Collections.emptySet(), ren));
			}
			ren = new HashMap<>(ren);
			if (!fv.contains(x0)) {
				ren.remove(x0);
				return lamAlg().Lam(x0, e0.subst(x, e, fv, ren));
			}
			String z = x0;
			while (fv.contains(z)) z += "_";
			ren.put(x0, z);
			return lamAlg().Lam(z, e0.subst(x, e, fv, ren));
		};
	}
	default Subst<Exp> App(Subst<Exp> e1, Subst<Exp> e2) {
		return (x, e, fv, ren) -> lamAlg().App(e1.subst(x, e, fv, ren), e2.subst(x, e, fv, ren));
	}
}
//END_CAPTURE_AVOID_WITHOUT_ID
