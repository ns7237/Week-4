package regex;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class CapitalizedWordsExtractor {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a senetence: ");
		String input = sc.nextLine();
		String capitalizedWordRegex = "\\b[A-Z][a-z]+\\b";
		Pattern pattern = Pattern.compile(capitalizedWordRegex);
		Matcher matcher = pattern.matcher(input);
		System.out.println("Capitalized Words Found: ");
		boolean found = false;
		while (matcher.find()) {
			System.out.println(matcher.group());
			found = true;
		}
		if(!found) {
			System.out.println("No capitalized words found.");
		}
		sc.close();
	}

}
