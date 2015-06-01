package expressionWithOOStyle;

import java.util.List;

public class VStringList implements Value{
	List<String> s;
	public VStringList(List<String> s){this.s = s;}
	@Override
	public Integer getInt() {
		return null;
	}
	@Override
	public List<String> getStringList() {
		return s;
	}
}
