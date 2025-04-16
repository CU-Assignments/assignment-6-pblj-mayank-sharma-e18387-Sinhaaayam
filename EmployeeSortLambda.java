import java.util.*;
import java.util.function.*;

class Employee {
    private String name;
    private int age;
    private double salary;

    // Constructor
    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    // Method to display employee details
    public void displayEmployee() {
        System.out.println("Name: " + name + ", Age: " + age + ", Salary: " + salary);
    }

    public static void main(String[] args) {
        // Create a list of Employee objects
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", 30, 60000));
        employees.add(new Employee("Bob", 25, 55000));
        employees.add(new Employee("Charlie", 28, 65000));
        employees.add(new Employee("David", 35, 70000));

        // Sort by name using lambda expression
        System.out.println("Employees sorted by Name:");
        employees.sort((e1, e2) -> e1.getName().compareTo(e2.getName()));
        employees.forEach(Employee::displayEmployee);

        // Sort by age using lambda expression
        System.out.println("\nEmployees sorted by Age:");
        employees.sort((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge()));
        employees.forEach(Employee::displayEmployee);

        // Sort by salary using lambda expression
        System.out.println("\nEmployees sorted by Salary:");
        employees.sort((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        employees.forEach(Employee::displayEmployee);
    }
}
