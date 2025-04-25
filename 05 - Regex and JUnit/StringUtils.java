package utils;

public class StringUtils {
	public static String reverse(String str) {
		return new StringBuilder(str).reverse().toString();
	}
	public static boolean isPalindrome(String str) {
		String reversed = reverse(str);
		return str.equalsIgnoreCase(reversed);
	}
	public static String toUpperCase(String str) {
		return str.toUpperCase();
	}
}
