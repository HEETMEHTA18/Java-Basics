import java.util.Scanner;
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

class AgeValidator {
    public void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or above. Given age: " + age);
        }
        System.out.println("Age is valid: " + age);
    }
}

public class ExceptionHandlingDemo {
    
    public static void demonstrateArithmeticException() {
        System.out.println("\n--- Arithmetic Exception Demo ---");
        try {
            int result = 10 / 0;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero!");
            System.out.println("Exception: " + e.getMessage());
        }
    }
    
    public static void demonstrateArrayException() {
        System.out.println("\n--- Array Index Out of Bounds Exception Demo ---");
        try {
            int[] arr = {1, 2, 3};
            System.out.println("Accessing index 5: " + arr[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Array index out of bounds!");
            System.out.println("Exception: " + e.getMessage());
        }
    }
    
    public static void demonstrateNullPointerException() {
        System.out.println("\n--- Null Pointer Exception Demo ---");
        try {
            String str = null;
            System.out.println("Length: " + str.length());
        } catch (NullPointerException e) {
            System.out.println("Error: Null pointer exception!");
            System.out.println("Cannot call method on null object");
        }
    }
    
    public static void demonstrateMultipleCatch() {
        System.out.println("\n--- Multiple Catch Blocks Demo ---");
        try {
            String str = "abc";
            int num = Integer.parseInt(str);
            System.out.println("Number: " + num);
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format!");
        } catch (Exception e) {
            System.out.println("Error: Some other exception occurred!");
        }
    }
    
    public static void demonstrateFinallyBlock() {
        System.out.println("\n--- Finally Block Demo ---");
        try {
            System.out.println("Inside try block");
            int result = 10 / 2;
            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.out.println("Inside catch block");
        } finally {
            System.out.println("Finally block always executes!");
        }
    }
    
    public static void demonstrateCustomException() {
        System.out.println("\n--- Custom Exception Demo ---");
        Scanner sc = new Scanner(System.in);
        AgeValidator validator = new AgeValidator();
        
        try {
            System.out.print("Enter your age: ");
            int age = sc.nextInt();
            validator.validateAge(age);
        } catch (InvalidAgeException e) {
            System.out.println("Custom Exception Caught: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: Invalid input!");
        }
    }
    
    public static void demonstrateThrows() throws ArithmeticException {
        System.out.println("\n--- Throws Keyword Demo ---");
        System.out.println("This method declares that it can throw ArithmeticException");
        int result = 100 / 5;
        System.out.println("Result: " + result);
    }

    public static void main(String[] args) {
        System.out.println("=== Exception Handling Demonstration ===");
        
        demonstrateArithmeticException();
        demonstrateArrayException();
        demonstrateNullPointerException();
        demonstrateMultipleCatch();
        demonstrateFinallyBlock();
        demonstrateCustomException();
        
        try {
            demonstrateThrows();
        } catch (ArithmeticException e) {
            System.out.println("Caught exception from demonstrateThrows()");
        }
        
        System.out.println("\n=== Program completed successfully ===");
        
        
        System.out.println("Student: 24CE084 krish patel");
        System.out.println("=".repeat(50));
    }
}
