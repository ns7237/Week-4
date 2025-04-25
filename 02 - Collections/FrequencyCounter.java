import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencyCounter {
    public static Map<String, Integer> countFrequency(List<String> items) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String item : items) {
            frequencyMap.put(item, frequencyMap.getOrDefault(item, 0) + 1);
        }
        return frequencyMap;
    }

    public static void main(String[] args) {
        List<String> inputList = new ArrayList<>();
        inputList.add("apple");
        inputList.add("banana");
        inputList.add("apple");
        inputList.add("orange");

        Map<String, Integer> result = countFrequency(inputList);
        System.out.println("Frequency Map: " + result);
    }
}
