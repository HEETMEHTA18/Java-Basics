package practical3_4;

public class AdminStaff extends Hospital {
    String department;

    public AdminStaff() {
        super(203, "GreenCare Hospital");
        this.department = "Billing";
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Role: Administrative Staff");
        System.out.println("Department: " + department);
    }
}
