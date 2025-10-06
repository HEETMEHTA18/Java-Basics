// StudentDemo.java - Demonstrates constructors, encapsulation, and methods
import java.util.Scanner;

class Student {
    private String name;
    private int ID;
    private String dept;
    private int salary;

    // Default constructor
    public Student() {
        name = "No name";
        ID = 0;
        dept = "No department";
        salary = 0;
    }

    // Parameterized constructor with constructor chaining
    public Student(String name, int ID, String dept, int salary) {
        this();
        this.name = name;
        this.ID = ID;
        this.dept = dept;
        this.salary = salary;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    public String getDept() {
        return dept;
    }

    public int getSalary() {
        return salary;
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + ID);
        System.out.println("Department: " + dept);
        System.out.println("Salary: " + salary);
    }
}

public class StudentDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== Student Information System ===\n");
        
        // Create student with default constructor
        Student s1 = new Student();
        System.out.println("Default Student:");
        s1.display();
        
        System.out.println("\n--- Enter Student Details ---");
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Department: ");
        String dept = sc.nextLine();
        System.out.print("Enter Salary: ");
        int salary = sc.nextInt();
        
        // Create student with parameterized constructor
        Student s2 = new Student(name, id, dept, salary);
        System.out.println("\nStudent Details Entered:");
        s2.display();
        
        System.out.println("\n" + "=".repeat(50));
        System.out.println("Student: 24CE064 HEET MEHTA");
        System.out.println("=".repeat(50));
        
        sc.close();
    }
}
