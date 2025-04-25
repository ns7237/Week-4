package q;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterStrings {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Apple", "Banana", "Avocado", "Cherry", "Apricot", "Mango");
        List<String> filtered = words.stream()
                                     .filter(s -> !s.startsWith("A"))
                                     .collect(Collectors.toList());
        System.out.println("Filtered List: " + filtered);
    }
}
