public class MainClass {
    public static void main(String[] args) {
        Institute_Management obj1 = new Student(101, "CSPIT", 501);
        Institute_Management obj2 = new Faculty(102, "DEPSTAR", "Computer Science");

        // Runtime Polymorphism
        obj1.showDetails();
        System.out.println("------------------");
        obj2.showDetails();
    }
}
