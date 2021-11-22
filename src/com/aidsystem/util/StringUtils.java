package com.aidsystem.util;

public class StringUtils {
	public static Integer getNumberFromString(String s) {
		if (s == null || "".equals(s)) { //必要！！！
			return null;
		}
		s = removeUnimportantChar(s);
		String string = s.replaceAll("[0-9]", "");
		string = s.replace(string, "");
		return new Integer(string);
	}
	
	public static String getOnlyStringFromString(String s) {
		if (s == null || "".equals(s)) {
			return null;
		}
		s = removeUnimportantChar(s);
		String string = s.replaceAll("[0-9]", "");
		return string;
	}
	
	public static String removeUnimportantChar(String s) {
		if (s == null || "".equals(s)) {
			return null;
		}
		s = s.replaceAll("[\\s]|[\n]|[\r]", "");
		return s;
	}

}
