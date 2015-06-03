package noa.util;

import java.util.List;

import static noa.util.Conventions.*;

public class NormalAlt extends Alt implements Conventions {

	private List<String> syms;
	private String cons;

	public NormalAlt(String nt, int prec, String cons, List<String> syms) {
		super(nt, prec);
		this.cons = cons;
		this.syms = syms;
	}

	public boolean isInfix() {
		String op = syms.get(1);
		return syms.size() == 3 && (isToken(op) || isLiteral(op));
	}
	
	public String getOperator() {
		assert isInfix();
		return syms.get(1);
	}
	
	public String getLhs() {
		assert isInfix();
		return syms.get(0);
	}
	
	public String getRhs() {
		assert isInfix();
		return syms.get(2);
	}
	
	public String toString() {
		String prod = "";
		String args = "";
		int labelCounter = 0;
		
		for (String s: syms) {
			if (isNonTerminal(s)) {
				prod += labelFor(labelCounter, s) + "=" + s + " ";
				args += "($" + labelFor(labelCounter, s) + "." + returnVariable(s) + "),";
				labelCounter += 1;
			}
			else if (isRegular(s)) {
				String n = getRegularSymbol(s);
				prod += labelFor(labelCounter, n) + "+=" + s + " ";
				args += "lift(\"" + returnVariable(n) + "\", $" + labelFor(labelCounter, n)  + "),";
				labelCounter += 1;
			}
			else if (isToken(s)) {
				prod += labelFor(labelCounter, s) + "=" + s + " ";
				args += s.toLowerCase() + "($" + labelFor(labelCounter, s) + ".text),";
				labelCounter += 1;
			}
			else if (isSepList(s)) {
				String n = getSepListSymbol(s);
				String label = labelFor(labelCounter, n);
				String eltHead = label + "=" + n;
				String eltTail = label + "tail+=" + n;
				String sep = getSepListToken(s);
				prod +=  "(" + eltHead+ " (" + sep + " " + eltTail + ")*)";
				if (isZeroOrMoreSepList(s)) {
					prod += "?";
				}
				args += "lift(\"" + returnVariable(n) + "\", $" + label + "tail, " + "$" + label + "." + returnVariable(n) + "),";
			}
			else {
				prod += s + " ";
			}
		}
		if (!args.isEmpty()) {
			// remove trailing comma
			args = args.substring(0, args.length() - 1);
		}
		prod += " {$" + returnVariable(getNT()) + " = " + BUILDER_FIELD + "." + cons + "(" + args + ");}";
		return prod;
	}

	public String getCons() {
		return cons;
	}

}
