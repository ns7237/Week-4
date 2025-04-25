import java.util.ArrayList;
import java.util.List;

public class ListRotator {
    public static <T> List<T> rotateList(List<T> list, int positions) {
        int size = list.size();
        if (size == 0 || positions % size == 0) return list;

        positions = positions % size;
        List<T> rotated = new ArrayList<>();
        rotated.addAll(list.subList(positions, size));
        rotated.addAll(list.subList(0, positions));
        return rotated;
    }

    public static void main(String[] args) {
        List<Integer> originalList = new ArrayList<>();
        originalList.add(10);
        originalList.add(20);
        originalList.add(30);
        originalList.add(40);
        originalList.add(50);

        int rotateBy = 2;
        List<Integer> rotatedList = rotateList(originalList, rotateBy);
        System.out.println("Original List: " + originalList);
        System.out.println("Rotated List: " + rotatedList);
    }
}
