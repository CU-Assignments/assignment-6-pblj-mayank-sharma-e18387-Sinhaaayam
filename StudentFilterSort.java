import java.util.*;
import java.util.stream.*;

class Student {
    private String name;
    private int marks;

    // Constructor
    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }

    // Method to display student details
    public void displayStudent() {
        System.out.println(name + " - Marks: " + marks);
    }

    public static void main(String[] args) {
        // Create a list of Student objects
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 82));
        students.add(new Student("Bob", 65));
        students.add(new Student("Charlie", 90));
        students.add(new Student("David", 78));
        students.add(new Student("Eve", 95));

        // Filter students with marks greater than 75, sort them by marks, and display their names
        students.stream()
            .filter(student -> student.getMarks() > 75) // Filter students with marks > 75
            .sorted(Comparator.comparingInt(Student::getMarks).reversed()) // Sort in descending order of marks
            .forEach(student -> System.out.println(student.getName())); // Display the names of the students
    }
}
