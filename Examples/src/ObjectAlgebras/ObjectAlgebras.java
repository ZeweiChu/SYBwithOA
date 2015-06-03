package ObjectAlgebras;

interface ExpAlg<E> {
	E Lit(int n);
	E Add(E l, E r);
}

interface MulAlg<E> extends ExpAlg<E> {
	E Mul(E l, E r);
}

class MulEval extends Eval 
 implements MulAlg<Integer> {
	public Integer Mul(Integer l, Integer r) {
		return l * r;
	}
}

class Eval implements ExpAlg<Integer> {
	public Integer Lit(int n) {
		return n; 
	}
	public Integer Add(Integer l, Integer r) {
		return l + r;
	}
}

class Print implements ExpAlg<String> {
	public String Lit(int n) { return "" + n; }
	public String Add(String l, String r) {
		return l + " + " + r;
	}
}

public class ObjectAlgebras {

	public static <E> E make3Plus5(ExpAlg<E> alg){
		return alg.Add(alg.Lit(3), alg.Lit(5));
	}
	public static void test(){
		Eval eval = new Eval();
		Print print = new Print();	
		int x = make3Plus5(eval);
		String s = make3Plus5(print);
		System.out.println("int: " + x); //int: 8
		System.out.println("String: " + s); //String: 3 + 5
	}
	public static void main(String[] argv){
		test();
	}
}
