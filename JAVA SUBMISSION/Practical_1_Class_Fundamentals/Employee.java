// Employee.java - Demonstrates class fundamentals, constructors, and methods
public class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;
    private static int count = 0;

    // Default constructor
    public Employee() {
        this(0, "Unknown", "General", 0.0);
    }

    // Parameterized constructor
    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        count++;
    }

    // Getter methods
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }

    // Setter methods
    public void setDepartment(String department) { this.department = department; }
    public void setSalary(double salary) { this.salary = salary; }

    // Static method
    public static int getEmployeeCount() { return count; }

    @Override
    public String toString() {
        return String.format("%-3d | %-15s | %-10s | ₹%.2f", id, name, department, salary);
    }

    public static void main(String[] args) {
        System.out.println("=== Employee Management System ===\n");
        
        Employee emp1 = new Employee(101, "Heet Mehta", "IT", 50000);
        Employee emp2 = new Employee(102, "Rahul Sharma", "HR", 45000);
        Employee emp3 = new Employee();
        
        System.out.println("Employee Details:");
        System.out.println(emp1);
        System.out.println(emp2);
        System.out.println(emp3);
        
        System.out.println("\nTotal Employees: " + Employee.getEmployeeCount());
        
        System.out.println("\n" + "=".repeat(50));
        System.out.println("Student: 24CE064 HEET MEHTA");
        System.out.println("=".repeat(50));
    }
}
