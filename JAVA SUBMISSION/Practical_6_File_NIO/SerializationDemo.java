import java.io.*;

class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String name;
    private int rollNumber;
    private String department;
    private transient String password; // transient field won't be serialized
    
    public Student(String name, int rollNumber, String department, String password) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.department = department;
        this.password = password;
    }
    
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", rollNumber=" + rollNumber +
                ", department='" + department + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

public class SerializationDemo {
    
    public static void serializeObject(Student student, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(student);
            System.out.println("Object serialized to " + filename);
            System.out.println("Serialized: " + student);
        } catch (IOException e) {
            System.err.println("Error during serialization: " + e.getMessage());
        }
    }
    
    public static Student deserializeObject(String filename) {
        Student student = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            student = (Student) ois.readObject();
            System.out.println(" Object deserialized from " + filename);
            System.out.println("Deserialized: " + student);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error during deserialization: " + e.getMessage());
        }
        return student;
    }

    public static void main(String[] args) {
        System.out.println("=== Object Serialization Demonstration ===\n");
        
        String filename = "student.ser";
        
        // Create student object
        Student student1 = new Student("Heet Mehta", 64, "Computer Engineering", "secret123");
        
        System.out.println("--- Original Object ---");
        System.out.println(student1);
        
        // Serialize
        System.out.println("\n--- Serialization ---");
        serializeObject(student1, filename);
        
        // Deserialize
        System.out.println("\n--- Deserialization ---");
        Student student2 = deserializeObject(filename);
        
        System.out.println("\n--- Note ---");
        System.out.println("Notice that the 'password' field is null after deserialization");
        System.out.println("because it was marked as 'transient'");
        
        System.out.println("\n=== Serialization demonstration completed ===");
        
        System.out.println("\n" + "=".repeat(50));
        System.out.println("Student: 24CE064 HEET MEHTA");
        System.out.println("=".repeat(50));
    }
}
