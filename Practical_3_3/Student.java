//package Practical_3_3;
////derived class
//
//import Student;
//
//public class Student extends Institue_Management {
//    String Sid;
//    String Sname;
//    String sem;
//
//    public Student() {
//        super();
//        System.out.println("This is the student class ");
//    }
//    public Student(int institute_code, String institute_name, String Sid, String Sname, String sem) {
//        super(institute_code, institute_name);
//        this.Sid = Sid;
//        this.Sname = Sname;
//        this.sem = sem;
//    }
//    public void display() {
//        super.display();
//        System.out.println("This is the student class ");
//        System.out.println("Student ID: " + Sid);
//        System.out.println("Student Name: " + Sname);
//        System.out.println("Semester: " + sem);
//    }
//    public static void main(String[] args) {
//        Student student = new Student(101, "Charusat University", "S123", "John Doe", "5th");
//        student.display();
//    }
//}