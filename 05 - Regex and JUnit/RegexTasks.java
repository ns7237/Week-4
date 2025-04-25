package regex;
import java.util.*;
import java.util.regex.*;

public class RegexTasks {
	public static boolean isValidIP(String ip) {
		String pattern = "^((25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\.){3}"
                + "(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)$";
		return ip.matches(pattern);
	}
	public static boolean isValidCard(String card) {
		return card.matches("^4\\d{15}$") || card.matches("^5\\d{15}$");
	}
	public static List<String> extractLanguages(String text) {
		List<String> langs = new ArrayList<>();
		Matcher m = Pattern.compile("\\b(Java|Python|JavaScript|Go)\\b").matcher(text);
		while (m.find()) langs.add(m.group());
		return langs;
	}
	public static List<String> extractCurrency(String text) {
		List<String> values = new ArrayList<>();
		Matcher m = Pattern.compile("\\$?\\d+\\.\\d{2}").matcher(text);
		while (m.find()) values.add(m.group());
		return values;
	}
	public static Set<String> findRepeats(String text) {
		Set<String> repeats = new HashSet<>();
		Matcher m = Pattern.compile("\\b(\\w+)\\s+\\1\\b").matcher(text);
		while(m.find()) repeats.add(m.group(1));
		return repeats;
	}
	public static boolean isValidSSN(String text) {
		return text.matches(".*\\b\\d{3}-\\d{2}-\\d{4}\\b.*");
	}
	public static boolean isValidUsername(String username) {
		return username.matches("^[a-zA-Z][a-zA-Z0-9_]{4,14}$");
	}
	public static void main(String[] args) {
		System.out.println("IPv4: " + isValidIP("192.168.0.1"));
        System.out.println("Card: " + isValidCard("4123456789012345")); 
        System.out.println("Languages: " + extractLanguages("I love Java, Python, and JavaScript, but I haven't tried Go yet."));
        System.out.println("Currency: " + extractCurrency("The price is $45.99, and the discount is 10.50."));
        System.out.println("Repeats: " + findRepeats("This is is a repeated repeated word test."));
        System.out.println("SSN: " + (isValidSSN("My SSN is 123-45-6789.") ? "Valid" : "Invalid"));
        System.out.println("Username 'user_123': " + (isValidUsername("user_123") ? "Valid" : "Invalid"));
        System.out.println("Username '123user': " + (isValidUsername("123user") ? "Valid" : "Invalid"));
        System.out.println("Username 'us': " + (isValidUsername("us") ? "Valid" : "Invalid"));
	}
	

}
