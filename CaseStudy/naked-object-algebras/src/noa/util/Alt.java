package noa.util;

public abstract class Alt implements Comparable<Alt>, Conventions {
	private String nt;
	private int prec;
	
	public Alt(String nt, int prec) {
		this.nt = nt;
		this.prec = prec;
	}
	
	public int getLevel() {
		return prec;
	}
	
	public String getNT() {
		return nt;
	}
	
	@Override
	public int compareTo(Alt o) {
		return new Integer(o.getLevel()).compareTo(getLevel());
	}
}
