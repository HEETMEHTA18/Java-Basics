package src.basics;

abstract class Staff {
    String name;
    int id;

    public Staff(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public abstract void work();
}


abstract class MedicalStaff extends Staff {
    public MedicalStaff(String name, int id) {
        super(name, id);
    }

    public abstract void attendPatient();
}


class Doctor extends MedicalStaff {
    public Doctor(String name, int id) {
        super(name, id);
    }

    @Override
    public void work() {
        System.out.println("Doctor " + name + " diagnoses and treats patients.");
    }

    @Override
    public void attendPatient() {
        System.out.println("Doctor " + name + " is attending to a patient.");
    }
}


class Nurse extends MedicalStaff {
    public Nurse(String name, int id) {
        super(name, id);
    }

    @Override
    public void work() {
        System.out.println("Nurse " + name + " provides patient care.");
    }

    @Override
    public void attendPatient() {
        System.out.println("Nurse " + name + " is assisting a patient.");
    }
}


class AdminStaff extends Staff {
    public AdminStaff(String name, int id) {
        super(name, id);
    }

    @Override
    public void work() {
        System.out.println("Admin Staff " + name + " manages records and billing.");
    }
}


final class FinanceTeam {
    public void generateSalaryReport() {
        System.out.println("Finance team is generating salary reports.");
    }
}

public class Practical3_1 {
    public static void main(String[] args) {

        Staff doc = new Doctor("Dr.Heet Mehta", 101);
        Staff nurse = new Nurse("Sister Radha", 102);
        Staff admin = new AdminStaff("Mr. Sharma", 103);


        doc.work();
        nurse.work();
        admin.work();

        System.out.println();


        if (doc instanceof Doctor) {
            Doctor d = (Doctor) doc;
            d.attendPatient();
        }

        if (nurse instanceof Nurse) {
            Nurse n = (Nurse) nurse;
            n.attendPatient();
        }

        System.out.println();

        // Final class usage
        FinanceTeam finance = new FinanceTeam();
        finance.generateSalaryReport();
    }
}
