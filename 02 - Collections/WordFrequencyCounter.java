import java.io.*;
import java.util.*;

public class WordFrequencyCounter {
    public static void countWordFrequency(String filePath) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            Map<String, Integer> wordFrequency = new HashMap<>();

            while ((line = reader.readLine()) != null) {

                line = line.replaceAll("[^a-zA-Z0-9\\s]", "").toLowerCase();

                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
                    }
                }
            }
            reader.close();

            System.out.println(wordFrequency);
        } catch (IOException e) {
            System.out.println("Error reading the file.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String filePath = "C:\\Users\\bvams\\IdeaProjects\\collections\\src\\text.txt";
        countWordFrequency(filePath);
    }
}
