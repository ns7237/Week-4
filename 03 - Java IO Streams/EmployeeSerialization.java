import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeSerialization {

    static class Employee implements Serializable {
        private static final long serialVersionUID = 1L;

        private int id;
        private String name;
        private String department;
        private double salary;

        public Employee(int id, String name, String department, double salary) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getDepartment() {
            return department;
        }

        public double getSalary() {
            return salary;
        }

        @Override
        public String toString() {
            return "Employee{id=" + id + ", name='" + name + "', department='" + department + "', salary=" + salary + "}";
        }
    }

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Alice", "HR", 50000));
        employees.add(new Employee(2, "Bob", "IT", 60000));
        employees.add(new Employee(3, "Charlie", "Finance", 55000));

        String fileName = "employees.ser";

        // Serialize the list of employees
        serializeEmployees(employees, fileName);

        // Deserialize the list of employees
        List<Employee> deserializedEmployees = deserializeEmployees(fileName);

        if (deserializedEmployees != null) {
            System.out.println("Deserialized Employees:");
            for (Employee employee : deserializedEmployees) {
                System.out.println(employee);
            }
        }
    }

    public static void serializeEmployees(List<Employee> employees, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(employees);
            System.out.println("Employees have been serialized successfully.");
        } catch (IOException e) {
            System.out.println("Error during serialization: " + e.getMessage());
        }
    }

    public static List<Employee> deserializeEmployees(String fileName) {
        List<Employee> employees = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            employees = (List<Employee>) ois.readObject();
            System.out.println("Employees have been deserialized successfully.");
        } catch (ClassNotFoundException e) {
            System.out.println("Error: Class not found during deserialization: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error during deserialization: " + e.getMessage());
        }
        return employees;
    }
}
