// Base Class
public class Institute_Management {
    int institute_code;
    public String institute_name;
    public final String location = "Charusat";

    // Default Constructor
    public Institute_Management() {
        System.out.println("Welcome to the Institute Management System");
    }

    // Parameterized Constructor
    public Institute_Management(int institute_code, String institute_name) {
        this.institute_code = institute_code;
        this.institute_name = institute_name;
    }

    // Method to show info (can be overridden)
    public void showDetails() {
        System.out.println("Institute Code: " + institute_code);
        System.out.println("Institute Name: " + institute_name);
        System.out.println("Location: " + location);
    }
}
