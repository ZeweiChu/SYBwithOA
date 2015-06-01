package lambAlgWithShy;

import java.util.Map;
import java.util.Set;

//BEGIN_INTERFACE_SUBSTARGS
public class SubstArgs<Exp> {
	public final String x;
	public final Exp e;
	public final Set<String> fv;
	public final Map<String, String> ren;
	public SubstArgs(String x, Exp e, Set<String> fv, Map<String, String> ren) {
		this.x = x;
		this.e = e;
		this.fv = fv;
		this.ren = ren;
	}
	public SubstArgs<Exp> setE(Exp e) {
		return new SubstArgs<Exp>(x, e, fv, ren);
	}	
	public SubstArgs<Exp> setX(String x) {
		return new SubstArgs<Exp>(x, e, fv, ren);
	}	
	public SubstArgs<Exp> setFV(Set<String> fv) {
		return new SubstArgs<Exp>(x, e, fv, ren);
	}	
	public SubstArgs<Exp> setRen(Map<String,String> ren) {
		return new SubstArgs<Exp>(x, e, fv, ren);
	}
}
//END_INTERFACE_SUBSTARGS
