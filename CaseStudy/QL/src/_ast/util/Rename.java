package _ast.util;

import java.util.Map;

public class Rename {
	public static String rename(Map<String, String> ren, String old) {
		String newName = old;
		if (ren.containsKey(old)) {
			newName = ren.get(old);
			//System.err.println("Renaming " + old + " to " + newName);
		}
		return newName;
	}
}
