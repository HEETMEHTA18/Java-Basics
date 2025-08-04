public class Student extends Institute_Management {
    int rollNo;

    public Student(int institute_code, String institute_name, int rollNo) {
        super(institute_code, institute_name); // Call base constructor
        this.rollNo = rollNo;
    }

    @Override
    public void showDetails() {
        super.showDetails();
        System.out.println("Role: Student");
        System.out.println("Roll No: " + rollNo);
    }
}
