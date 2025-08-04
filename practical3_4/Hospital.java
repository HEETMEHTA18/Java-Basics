package practical3_4;

public class Hospital {
    int hospitalCode;
    String hospitalName;
    final String location = "Ahmedabad";

    public Hospital() {
        System.out.println("Welcome to the Hospital Management System");
    }

    public Hospital(int hospitalCode, String hospitalName) {
        this.hospitalCode = hospitalCode;
        this.hospitalName = hospitalName;
    }

    public void display() {
        System.out.println("Hospital Code: " + hospitalCode);
        System.out.println("Hospital Name: " + hospitalName);
        System.out.println("Location: " + location);
    }

    public void changeHospitalName(String newName) {
        this.hospitalName = newName;
    }
}
