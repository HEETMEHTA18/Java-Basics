package practical3_4;

public class MainHospital {
    public static void main(String[] args) {
        Hospital h1 = new Doctor();
        Hospital h2 = new Nurse();
        Hospital h3 = new AdminStaff();

        System.out.println("\n--- Doctor Details ---");
        h1.display();

        System.out.println("\n--- Nurse Details ---");
        h2.display();

        System.out.println("\n--- Admin Staff Details ---");
        h3.display();

        h1.changeHospitalName("Apex Hospital");
        System.out.println("\nAfter name change:");
        h1.display();
    }
}
