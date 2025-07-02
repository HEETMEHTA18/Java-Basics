package Code;
public class Student 
{
    int rollNum;
    String name;

    public Student(int rollNum, String name) {
        this.rollNum = rollNum;
        this.name = name;
    }
    void display() {
        System.out.println("Roll Number: " + rollNum + ", Name: " + name);
    }

}

public class Exam extends Student
{
    int marks;

    public Exam(int rollNum, String name, int marks) {
        super(rollNum, name);
        this.marks = marks;
    }

    @Override
    void display() {
        super.display();
        System.out.println("Marks: " + marks);
    }

}
public class Main {

    public static void main(String[] args) {
       
        
       Student student1 = new Student(102, "Bob");
    
    Student student2 = new Student(102, "Bob");
    
    Student student3 = new Student(102, "Bob");
        student1.display();
        student2.display();
        student3.display();
    }
    
}
