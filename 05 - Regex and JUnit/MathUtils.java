package utils;

public class MathUtils {
    public static int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero not allowed");
        }
        return a / b;
    }
}
