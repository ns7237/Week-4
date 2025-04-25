import java.util.*;

class Employee {
    String name;
    Department department;

    public Employee(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return name;
    }
}

enum Department {
    HR, IT, SALES, MARKETING
}

public class GroupByDepartment {
    public static Map<Department, List<Employee>> groupByDepartment(List<Employee> employees) {
        Map<Department, List<Employee>> departmentMap = new HashMap<>();

        for (Employee employee : employees) {
            departmentMap
                    .computeIfAbsent(employee.getDepartment(), k -> new ArrayList<>())
                    .add(employee);
        }

        return departmentMap;
    }

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", Department.HR));
        employees.add(new Employee("Bob", Department.IT));
        employees.add(new Employee("Carol", Department.HR));

        Map<Department, List<Employee>> groupedByDepartment = groupByDepartment(employees);

        for (Map.Entry<Department, List<Employee>> entry : groupedByDepartment.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
