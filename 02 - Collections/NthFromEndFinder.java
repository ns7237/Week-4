import java.util.LinkedList;
import java.util.ListIterator;

public class NthFromEndFinder {
    public static <T> T findNthFromEnd(LinkedList<T> list, int n) {
        ListIterator<T> first = list.listIterator();
        ListIterator<T> second = list.listIterator();

        for (int i = 0; i < n; i++) {
            if (first.hasNext()) {
                first.next();
            } else {
                return null;
            }
        }

        while (first.hasNext()) {
            first.next();
            second.next();
        }

        return second.next();
    }

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        int n = 2;
        String result = findNthFromEnd(list, n);
        System.out.println("Nth element from the end: " + result);
    }
}
