package q;

import java.util.*;

class Person {
    String name;
    int age;
    double salary;

    Person(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String toString() {
        return name + " - Age: " + age + ", Salary: " + salary;
    }
}

public class SortByAge {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
            new Person("Alice", 30, 50000),
            new Person("Bob", 25, 45000),
            new Person("Charlie", 35, 60000),
            new Person("Diana", 28, 52000)
        );

        people.sort((p1, p2) -> Integer.compare(p1.age, p2.age));

        for (Person p : people) {
            System.out.println(p);
        }
    }
}
