package regex;
import java.util.*;
public class CensorBadWords {
	public static String censor(String sentence, Set<String> badWords) {
		String[] words = sentence.split(" ");
		StringBuilder result = new StringBuilder();
		for (String word : words) {
			String strippedWord = word.replaceAll("[^a-zA-Z]", ""); 
			String censoredWord;
			if (badWords.contains(strippedWord.toLowerCase())) {
				censoredWord = word.replace(strippedWord, "*****");
			} else {
				censoredWord = word;
			}
			result.append(censoredWord).append(" ");
		}
		return result.toString().trim();
	}
	public static void main(String[] args) {
		String sentence = "This is a damn bad example with some stupid words.";
		Set<String> badWords = new HashSet<>(Arrays.asList("damn", "stupid"));
		
		String censored = censor(sentence, badWords);
		System.out.println(censored);
	}
}
