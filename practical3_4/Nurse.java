package practical3_4;

class Nurse extends Hospital {
    int shiftHours;

    public Nurse() {
        super(202, "Sunrise Hospital");
        this.shiftHours = 8;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Role: Nurse");
        System.out.println("Shift Hours: " + shiftHours + " hours");
    }
}
