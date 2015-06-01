package expressionWithOOStyle;

import java.util.List;

public class ExpTest {

	static Exp genStringListExp(){
		return new StringListAdd(new StringListAdd(new StringListVar("var1"), new StringListVar("var2")), new StringListLit(5));
	}
	
	static Exp genIntExp(){
		return new IntAdd(new IntAdd(new IntVar("var1"), new IntVar("var2")), new IntLit(5));
	}
	
	public static void main(String[] args) {
		Exp exp = genStringListExp();
		Exp exp2 = exp.subst("var1", new StringListVar("var4"));
		List<String> ls = exp2.query().getStringList();
		for (String s: ls){System.out.println(s);}
		
		System.out.println("***********************");
		
		exp = genIntExp();
		Integer res = exp.query().getInt();
		System.out.println(res);
		
		
		
	}

}
