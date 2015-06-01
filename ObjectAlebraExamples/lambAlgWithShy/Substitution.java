package lambAlgWithShy;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@SuppressWarnings("serial")
//BEGIN_CAPTURE_AVOID_WITH_ID
public interface Substitution<Exp> extends G_ExpAlgTransform<SubstArgs<Exp>, Exp>, G_LamAlgTransform<SubstArgs<Exp>, Exp> {
	default Function<SubstArgs<Exp>, Exp> Var(String s) {
		return (args) -> {
			if (rename(args.ren, s).equals(args.x)) {
				return args.e;
			}
			return expAlg().Var(rename(args.ren, s));
		};
	}
	default Function<SubstArgs<Exp>,Exp> Lam(String x0, Function<SubstArgs<Exp>,Exp> e0) {
		return (args) -> {
			if (x0.equals(args.x)) {
				return lamAlg().Lam(x0, e0.apply(args.setE(expAlg().Var(x0)).setFV(Collections.singleton(x0))));
			}
			if (!args.fv.contains(x0)) {
				return lamAlg().Lam(x0, e0.apply(args.setRen(remove(args.ren, x0))));
			}
			String z = x0;
			while (args.fv.contains(z)) z += "_";
			return lamAlg().Lam(z, e0.apply(args.setRen(add(args.ren, x0, z))));
		};
	}
	static Map<String, String> remove(Map<String, String> ren, String y) {
		return new HashMap<String,String>(ren) {{ remove(y); }};
	}
	static Map<String,String> add(Map<String, String> ren, String x, String z) {
		return new HashMap<String,String>(ren) {{ put(x, z); }};
	}
	static String rename(Map<String,String> renaming, String x) {
		if (renaming.containsKey(x)) {
			return renaming.get(x);
		}
		return x;
	}
}
//END_CAPTURE_AVOID_WITH_ID
