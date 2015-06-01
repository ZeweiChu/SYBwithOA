package lamAlgWithOA;

import java.util.Map;
import java.util.Set;

//BEGIN_INTERFACE_SUBST
public interface Subst<Exp> {
	Exp subst(String x, Exp e, Set<String> fv, Map<String, String> ren);
}
//END_INTERFACE_SUBST
