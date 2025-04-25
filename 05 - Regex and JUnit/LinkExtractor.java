package regex;
import java.util.regex.*;
import java.util.Scanner;
public class LinkExtractor {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the text containing urls: ");
		String input = sc.nextLine();
		String urlRegex = "https?://[\\w.-]+(?:\\.[\\w.-]+)+[/\\w\\-._~:?#[\\]@!$&'()*+,;=]*";
		Pattern pattern = Pattern.compile(urlRegex);
		Matcher matcher = pattern.matcher(input);
		System.out.println("Extrcated Links:" );
		boolean found = false;
		while(matcher.find()) {
			System.out.println(matcher.group());
			found = true;
		}
		if(!found) {
			System.out.println("No liks found.");
		}
		sc.close();
		
	}

}
