import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetToSortedList {
    public static List<Integer> convertToSortedList(Set<Integer> set) {
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        return list;
    }

    public static void main(String[] args) {
        Set<Integer> inputSet = new HashSet<>();
        inputSet.add(5);
        inputSet.add(3);
        inputSet.add(9);
        inputSet.add(1);

        List<Integer> sortedList = convertToSortedList(inputSet);
        System.out.println("Sorted List: " + sortedList);
    }
}
