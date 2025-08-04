public class Faculty extends Institute_Management {
    String department;

    public Faculty(int institute_code, String institute_name, String department) {
        super(institute_code, institute_name);
        this.department = department;
    }

    @Override
    public void showDetails() {
        super.showDetails();
        System.out.println("Role: Faculty");
        System.out.println("Department: " + department);
    }
}
