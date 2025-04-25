package regex;
import java.util.regex.*;
import java.util.Scanner;
public class DateExtractor {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a sentence with dates: ");
		String input = sc.nextLine();
		String dateRegex = "\\b(0[1-9]|[12][0-9]|3[01])/"
                + "(0[1-9]|1[0-2])/"
                + "\\d{4}\\b";
		Pattern pattern = Pattern.compile(dateRegex);
		Matcher matcher = pattern.matcher(input);
		System.out.println("Extracted Dates: ");
		boolean found = false;
		while(matcher.find()) {
			System.out.println(matcher.group());
			found = true;
		}
		if(!found) {
			System.out.println("No valid dates found.");
		}
		sc.close();
	}

}
