package q;

import java.util.function.Function;

public class CircleArea {
    public static void main(String[] args) {
        Function<Double, Double> areaOfCircle = r -> Math.PI * r * r;

        double radius = 5.0;
        double area = areaOfCircle.apply(radius);

        System.out.println("Area of circle with radius " + radius + " is: " + area);
    }
}
