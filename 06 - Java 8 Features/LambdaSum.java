package q;

@FunctionalInterface
interface SumFunction {
    int sum(int a, int b);
}

public class LambdaSum {
    public static void main(String[] args) {
        SumFunction adder = (a, b) -> a + b;
        int result = adder.sum(10, 20);
        System.out.println("Sum: " + result);
    }
}
