package regex;

import java.util.Scanner;

public class HexColorValidator {
	public static boolean isValidHexColor(String color) {
		if (color.length() != 7 || color.charAt(0) != '#') {
			return false;
		}
		for (int i = 1; i < 7; i++) {
			char ch = color.charAt(i);
			if (!isHexDigit(ch)) {
				return false;
			}
		}
		return true;
	}
	public static boolean isHexDigit(char ch) {
		return (ch >= '0' && ch <= '9') ||
				(ch >= 'A' && ch <= 'F') || 
				(ch >= 'a' && ch <= 'f');
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a hex color code: ");
		String color = sc.nextLine();
		if(isValidHexColor(color)) {
			System.out.println(color + "is a valid Hex Color Code");
		} else {
			System.out.println(color + "is an invalid Hex Color Code");
		}
		sc.close();
	}

}
