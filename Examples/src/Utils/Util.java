package Utils;

import java.util.ArrayList;
import java.util.List;

public class Util {
	public static <X> List<X> cons(X x, List<X> l) {
		l = new ArrayList<>(l);
		l.add(0, x);
		return l;
	}
}
