package practical3_4;

public class Doctor extends Hospital {
    String specialization;

    public Doctor() {
        super(201, "City Hospital");
        this.specialization = "Cardiology";
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Role: Doctor");
        System.out.println("Specialization: " + specialization);
    }
}
