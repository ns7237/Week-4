package q;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateFilter {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("airplane", "banana", "chair", "rainfall", "paint", "train");

        Predicate<String> lengthGreaterThanFive = s -> s.length() > 5;
        Predicate<String> containsSubstring = s -> s.contains("ai");

        List<String> filtered = words.stream()
                                     .filter(lengthGreaterThanFive.and(containsSubstring))
                                     .collect(Collectors.toList());

        System.out.println("Filtered List: " + filtered);
    }
}
