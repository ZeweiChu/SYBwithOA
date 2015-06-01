package expressionWithOOStyle;

import java.util.List;

public class VInt implements Value {
	int x;
	public VInt(int x){this.x = x;}
	@Override
	public Integer getInt() {
		return x;
	}
	@Override
	public List<String> getStringList() {
		return null;
	}
}
