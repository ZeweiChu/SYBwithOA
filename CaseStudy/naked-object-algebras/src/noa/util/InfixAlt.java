package noa.util;

import java.util.Map;

import static noa.util.Conventions.*;

public class InfixAlt extends Alt {
	private Map<String, String> tokenConsMap;

	public InfixAlt(String nt, int prec, Map<String,String> tokenConsMap) {
		super(nt, prec);
		this.tokenConsMap = tokenConsMap;
	}

	
	@Override
	public String toString() {
		String prod = "";
		
		// LHS
		String l1 = labelFor(0, getNT());
		prod += l1 + "=" + getNT() + " ";
		
		String op = "(";
		for (String token: tokenConsMap.keySet()) {
			op += token + "|";
		}
		op = op.substring(0, op.length() - 1) + ")";
		String opLabel = "op_" + getLevel();
		prod += opLabel + "=" + op + " ";
		
		// RHS
		String l2 = labelFor(1, getNT());
		prod += l2 + "=" + getNT() + " ";
		
		prod += " {$" + returnVariable(getNT()) + " = " + buildBuildExp(l1, opLabel, l2) + ";}";
		return prod;
	}


	private String buildBuildExp(String l1, String label, String l2) {
		String exp = "null";
		for (String token: tokenConsMap.keySet()) {
			assert isLiteral(token);
			exp = tokenCondition(label, token) + " ? "  + buildExp(l1, l2, token) + " : " + exp;
		}
		return exp;
	}


	private String buildExp(String l1, String l2, String token) {
		return BUILDER_FIELD + "." + tokenConsMap.get(token) + "(" + buildArg(l1) + ", " + buildArg(l2) + ")";
	}


	private String buildArg(String l1) {
		return "$" + l1 + "." + returnVariable(getNT());
	}


	private String tokenCondition(String label, String token) {
		return "$" + label + ".text.equals(\"" + token.substring(1, token.length() - 1) + "\")";
	}

}
