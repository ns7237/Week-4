import java.util.Scanner;

public class NestedtryCatchExample {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter the array size: ");
            int size = scanner.nextInt();

            int[] array = new int[size];

            System.out.print("Enter an index to access: ");
            int index = scanner.nextInt();

            try {
                // Try accessing the element at the given index
                int value = array[index];

                System.out.print("Enter a divisor: ");
                int divisor = scanner.nextInt();

                try {
                    // Try dividing the value by the divisor
                    int result = value / divisor;
                    System.out.println("Result: " + result);
                } catch (ArithmeticException e) {
                    System.out.println("Cannot divide by zero!");
                }

            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid array index!");
            }

        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
