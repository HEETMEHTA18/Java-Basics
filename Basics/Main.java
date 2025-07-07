package Basics;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);


        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Department: ");
        String department = sc.nextLine();

        System.out.print("Salary: ");
        double salary = sc.nextDouble();


        Employee employee1 = new Employee(id, name, salary, department);





        System.out.println("\nEmployee details:");
        System.out.println("Employee-Data:");
        employee1.display();

//        System.out.println("\nEmployee details:");
//        System.out.println("Employee-Data:");
//        employee2.display();
//
//        System.out.println("\nEmployee details:");
//        System.out.println("Employee-Data:");
//        employee3.display();

        sc.close();
    }
}
