package Basics;

// Employee.java


public class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;
    private static int count = 0;

    public Employee() {
        this(0, "Unknown", "General", 0.0);
    }

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        count++;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }

    public void setDepartment(String department) { this.department = department; }
    public void setSalary(double salary) { this.salary = salary; }

    public static int getEmployeeCount() { return count; }

    @Override
    public String toString() {
        return String.format("%-3d | %-15s | %-10s | ₹%.2f", id, name, department, salary);
    }
}

// PermanentEmployee class (subclass)
class PermanentEmployee extends Employee {
    private double providentFundRate = 0.12;

    public PermanentEmployee(int id, String name, String department, double salary) {
        super(id, name, department, salary);
    }

    public double annualCTC() {
        return getSalary() * 12 * (1 + providentFundRate);
    }
}

// ContractEmployee class (subclass)
class ContractEmployee extends Employee {
    private int contractMonths;

    public ContractEmployee(int id, String name, String department, double salary, int contractMonths) {
        super(id, name, department, salary);
        this.contractMonths = contractMonths;
    }

    public int getContractMonths() {
        return contractMonths;
    }
}
