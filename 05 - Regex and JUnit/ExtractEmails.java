package regex;
import java.util.*;
import java.util.regex.*;

public class ExtractEmails {
    public static List<String> extractEmails(String text) {
        List<String> emails = new ArrayList<>();
        Pattern pattern = Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            emails.add(matcher.group());
        }
        return emails;
    }
    public static void main(String[] args) {
        String text = "Contact us at support@example.com and info@company.org";
        List<String> emailList = extractEmails(text);
        System.out.println("Extracted Emails:");
        for (String email : emailList) {
            System.out.println(email);
        }
    }
}
