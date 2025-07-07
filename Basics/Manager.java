package Basics;

// Manager.java
public class Manager {
    public static void main(String[] args) {
        Employee e1 = new Employee();
        e1.setDepartment("HR");
        e1.setSalary(25000);

        Employee e2 = new Employee(102, "Riya Patel", "Finance", 48000);

        PermanentEmployee p1 = new PermanentEmployee(201, "Aman Shah", "Engineering", 60000);
        ContractEmployee c1 = new ContractEmployee(301, "Sara Khan", "Design", 40000, 18);

        System.out.println("ID  | Name            | Dept       | Salary");
        System.out.println("-----------------------------------------------");
        for (Employee emp : new Employee[]{e1, e2, p1, c1}) {
            System.out.println(emp);
        }

        System.out.println("\nTotal employees created: " + Employee.getEmployeeCount());

        if (p1 instanceof PermanentEmployee) {
            System.out.printf("%s is a permanent employee with CTC ₹%.0f%n",
                    p1.getName(), p1.annualCTC());
        }

        if (c1 instanceof ContractEmployee) {
            System.out.printf("%s has a %d-month contract%n",
                    c1.getName(), c1.getContractMonths());
        }
    }
}
