package q;

@FunctionalInterface
interface SquareCalculator {
    int square(int x);

    default void printResult(int x) {
        System.out.println("The square of " + x + " is: " + square(x));
    }
}

public class CustomFunctionalInterfaceDemo {
    public static void main(String[] args) {
        SquareCalculator calculator = n -> n * n;

        calculator.printResult(7);
    }
}
