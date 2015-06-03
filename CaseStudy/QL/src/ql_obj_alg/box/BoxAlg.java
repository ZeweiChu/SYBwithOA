package ql_obj_alg.box;

import java.util.Arrays;
import java.util.List;

@SuppressWarnings("unchecked")
public interface BoxAlg<X> {
	X H(int hs, List<X> kids);
	X V(int vs, List<X> kids);
	X I(int is, int vs, List<X> kids);
	
	X L(String txt);
	
	default X H(List<X> kids) {
		return H(0, kids);
	}
	
	default X V(List<X> kids) {
		return V(1, kids);
	}
	
	default X I(List<X> kids) {
		return I(1, kids);
	}
	
	default X H(X... kids) {
		return H(Arrays.asList(kids));
	}

	default X V(X... kids) {
		return V(Arrays.asList(kids));
	}

	default X I(X... kids) {
		return I(Arrays.asList(kids));
	}

	default X H(int hs, X ...kids) {
		return H(hs, Arrays.asList(kids));
	}
	
	default X V(int vs, X ...kids) {
		return V(vs, Arrays.asList(kids));
	}
	
	default X I(int is, X ...kids) {
		return I(is, Arrays.asList(kids));
	}
	
	default X I(int is, int vs, X ...kids) {
		return I(is, vs, Arrays.asList(kids));
	}
	
	default X I(int is, List<X> kids) {
		return I(is, 1, kids);
	}
}
