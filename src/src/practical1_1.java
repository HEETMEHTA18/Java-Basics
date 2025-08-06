package Basics
import java.util.Scanner;


class Class1_1 {
    private String name;
    private int ID;
    private String dept;
    private int salary;

    public Class1_1() {
        name = "No name";
        ID = 0;
        dept = "No department";
        salary = 0;
    }


    public Class1_1(String name, int ID, String dept, int salary) {
        this();
        this.name = name;
        this.ID = ID;
        this.dept = dept;
        this.salary = salary;
    }


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
}

public class practical1_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your name: ");
        String name = sc.nextLine();

        System.out.println("Enter your ID: ");
        int ID = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter your department: ");
        String dept = sc.nextLine();

        System.out.println("Enter your salary: ");
        int salary = sc.nextInt();

        Class1_1 obj = new Class1_1(name, ID, dept, salary);

        System.out.println("\n--- Student Info ---");
        System.out.println("Name: " + obj.getName());
        System.out.println("Student ID: " + obj.getID());
        System.out.println("Department: " + obj.getDept());
        System.out.println("Salary: " + obj.getSalary());

        sc.close();
    }
}