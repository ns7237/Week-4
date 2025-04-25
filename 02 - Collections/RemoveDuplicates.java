import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicates {
    public static <T> List<T> removeDuplicates(List<T> list) {
        Set<T> seen = new LinkedHashSet<>(list);
        return new ArrayList<>(seen);
    }

    public static void main(String[] args) {
        List<Integer> inputList = new ArrayList<>();
        inputList.add(3);
        inputList.add(1);
        inputList.add(2);
        inputList.add(2);
        inputList.add(3);
        inputList.add(4);

        List<Integer> result = removeDuplicates(inputList);
        System.out.println("Original List: " + inputList);
        System.out.println("List without duplicates: " + result);
    }
}
