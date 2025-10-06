interface Student {
    void displayClass();
    void setName(String name);
    
    default void showInfo() {
        System.out.println("This is a default method in Student interface");
    }
    
    static String getInstituteLocation() {
        return "Charusat, Gandhinagar";
    }
}

interface Scholarship {
    boolean isEligible(double cgpa);
}

class InstituteManagement implements Student, Scholarship {
    int instituteCode;
    String instituteName;
    final String location = "Charusat";

    public InstituteManagement() {
        System.out.println("Welcome to the Institute Management System");
    }

    public InstituteManagement(int instituteCode, String instituteName) {
        this.instituteCode = instituteCode;
        this.instituteName = instituteName;
    }

    public void display() {
        System.out.println("Institute Code: " + instituteCode);
        System.out.println("Institute Name: " + instituteName);
        System.out.println("Location: " + location);
    }

    @Override
    public void displayClass() {
        System.out.println("Displaying class information through interface");
    }

    @Override
    public void setName(String name) {
        this.instituteName = name;
        System.out.println("Institute name set to: " + name);
    }

    @Override
    public boolean isEligible(double cgpa) {
        return cgpa >= 8.0;
    }
}

public class InterfaceDemo {
    public static void main(String[] args) {
        System.out.println("=== Interface Demonstration ===\n");
        
        InstituteManagement institute = new InstituteManagement(101, "Charusat University");
        
        System.out.println("--- Institute Details ---");
        institute.display();
        
        System.out.println("\n--- Interface Methods ---");
        institute.displayClass();
        institute.setName("CSPIT - Charusat");
        institute.showInfo();
        
        System.out.println("\n--- Static Interface Method ---");
        System.out.println("Location: " + Student.getInstituteLocation());
        
        System.out.println("\n--- Scholarship Eligibility ---");
        System.out.println("CGPA 8.5 eligible: " + institute.isEligible(8.5));
        System.out.println("CGPA 7.5 eligible: " + institute.isEligible(7.5));
        
        
        System.out.println("Student: 24CE084 KRISH PATEL");
        System.out.println("=".repeat(50));
    }
}
