package regex;
import java.util.Scanner;
public class UsernameValidator {
	public static boolean isValidUsername(String username) {
		if(username.length() < 5 || username.length() > 15) {
			return false;
		}
		if(!Character.isLetter(username.charAt(0))) {
			return false;
		}
		for (int i = 0; i < username.length(); i++) {
			char ch = username.charAt(i);
			if(!Character.isLetterOrDigit(ch) && ch != '_') {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a usernmae: ");
		String username = sc.nextLine();
		if(isValidUsername(username)) { 
			System.out.println(username + " is a Valid Username");
		} else {
			System.out.println(username + "is an Inavlid Username");
		}
		sc.close();
	}

}
