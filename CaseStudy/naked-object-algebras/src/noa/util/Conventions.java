package noa.util;

public interface Conventions {
	static final String BUILDER_FIELD = "builder";
	static final int MAX_PRECEDENCE = Integer.MAX_VALUE;
	
	static boolean hasPlaceholder(String s) {
		return s.startsWith("_");
	}

	static boolean isToken(String s) {
		return s.matches("^[A-Z][a-zA-Z]*$");
	}
	
	static boolean isLiteral(String op) {
		return op.matches("^'.*'$");
	}

	static boolean isNonTerminal(String s) {
		return s.matches("^[a-z][a-zA-Z]*$");
	}

	static boolean isRegular(String s) {
		return s.matches("^[a-z][a-zA-Z]*[*+?]$");
	}
	
	static String getRegularSymbol(String s) {
		return s.substring(0, s.length() - 1);
	}
	
	static boolean isSepList(String s) {
		return s.matches("^[a-z][a-zA-Z]*@'.+'*[*+]$");
	}
	
	static boolean isZeroOrMoreSepList(String s) {
		return s.charAt(s.length() - 1) == '*';
	}
	
	static boolean isOneOrMoreSepList(String s) {
		return s.charAt(s.length() - 1) == '+';
	}
	
	static String getSepListSymbol(String s) {
		return s.substring(0, s.indexOf('@'));
	}
	
	static String getSepListToken(String s) {
		return s.substring(s.indexOf('@') + 1, s.length() - 1);
	}

	static String labelFor(int n, String sym) {
		return sym + "_" + n;
	}
	
	static String returnVariable(String nt) {
		return "_" + nt;
	}
	
}
