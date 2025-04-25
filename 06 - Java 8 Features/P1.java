package q;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Employee {
    int id;
    String name;
    String department;
    double salary;

    Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', department='" + department + "', salary=" + salary + '}';
    }
}

public class P1{
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "Alice", "Engineering", 95000),
            new Employee(2, "Bob", "HR", 75000),
            new Employee(3, "Charlie", "Engineering", 88000),
            new Employee(4, "David", "Engineering", 70000),
            new Employee(5, "Eve", "HR", 82000),
            new Employee(6, "Frank", "Engineering", 105000)
        );

        List<Employee> filteredEmployees = employees.stream()
            .filter(e -> e.department.equals("Engineering") && e.salary > 80000)
            .collect(Collectors.toList());

        List<Employee> sortedEmployees = filteredEmployees.stream()
            .sorted((e1, e2) -> Double.compare(e2.salary, e1.salary))
            .collect(Collectors.toList());

        Map<String, List<Employee>> groupedByDepartment = sortedEmployees.stream()
            .collect(Collectors.groupingBy(e -> e.department));

        Map<String, Double> averageSalaryByDepartment = groupedByDepartment.entrySet().stream()
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                entry -> entry.getValue().stream()
                    .mapToDouble(e -> e.salary)
                    .average()
                    .orElse(0.0)
            ));

        System.out.println("Filtered and Sorted Employees: ");
        sortedEmployees.forEach(System.out::println);

        System.out.println("\nGrouped by Department: ");
        groupedByDepartment.forEach((department, employeeList) -> {
            System.out.println(department + ": " + employeeList);
        });

        System.out.println("\nAverage Salary by Department: ");
        averageSalaryByDepartment.forEach((department, avgSalary) -> {
            System.out.println(department + ": " + avgSalary);
        });
    }
}
