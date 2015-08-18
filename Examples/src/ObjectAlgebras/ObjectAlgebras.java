package ObjectAlgebras;

interface ExpAlg<E> {
	E Lit(int n);
	E Add(E l, E r);
}

interface MulAlg<E> extends ExpAlg<E> {
	E Mul(E l, E r);
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

class MulEval extends Eval 
 implements MulAlg<Integer> {
	public Integer Mul(Integer l, Integer r) {
		return l * r;
	}
}

public class ObjectAlgebras {
	<E> E makeExp(ExpAlg<E> alg){
		return alg.Add(alg.Lit(2), alg.Lit(3));
	}
	<E> E makeMul(MulAlg<E> alg){
		return alg.Mul(alg.Add(alg.Lit(2), alg.Lit(3)), alg.Lit(4));
	}
	public int evalExp() {
		return makeExp(new Eval());
	}
	public String printExp() {
		return makeExp(new Print());
	}
	public int evalMul() {
		return makeMul(new MulEval());
	}
}
