package monoids;

public class Triple<A, B, C> {
	public final A a;
	public final B b;
	public final C c;
	
	public Triple(A a, B b, C c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Triple)) {
			return false;
		}
		Triple<A,B,C> t = (Triple<A, B, C>)obj;
		return a.equals(t.a) && b.equals(t.b) && c.equals(t.c);
	}
	
	@Override
	public int hashCode() {
		return a.hashCode() + b.hashCode() + c.hashCode();
	}
	
	@Override
	public String toString() {
		return "<" + a + ", " + b + ", " + c + ">";
	}

}
