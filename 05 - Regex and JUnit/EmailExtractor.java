package regex;

import java.util.*;
import java.util.regex.*;

public class EmailExtractor {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enetr a text containing email addresses: ");
		String input = sc.nextLine();
		String emailRegex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";
		Pattern pattern = Pattern.compile(emailRegex);
		Matcher matcher = pattern.matcher(input);
		System.out.println("Extracted email addresses: ");
		boolean found = false;
		while (matcher.find()) {
			System.out.println(matcher.group());
			found = true;
		}
		if(!found) {
			System.out.println("No email addresses found.");
		}
	
		sc.close();
	}

}
