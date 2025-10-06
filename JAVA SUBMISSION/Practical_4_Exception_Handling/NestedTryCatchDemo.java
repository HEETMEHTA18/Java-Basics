public class NestedTryCatchDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Nested Try-Catch Demonstration ===\n");
        
        try {
            System.out.println("Outer try block started");
            
            try {
                System.out.println("Inner try block started");
                int[] arr = {1, 2, 3};
                System.out.println("Element at index 1: " + arr[1]);
                
                // This will cause ArithmeticException
                int result = 10 / 0;
                System.out.println("Result: " + result);
                
            } catch (ArithmeticException e) {
                System.out.println("Inner catch: Arithmetic Exception caught!");
                System.out.println("Message: " + e.getMessage());
            }
            
            System.out.println("\nBack to outer try block");
            // This will cause ArrayIndexOutOfBoundsException
            int[] numbers = {10, 20, 30};
            System.out.println("Accessing invalid index: " + numbers[10]);
            
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Outer catch: Array Index Exception caught!");
            System.out.println("Message: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Outer catch: General Exception caught!");
        } finally {
            System.out.println("\nOuter finally block executed");
        }
        
        System.out.println("\n=== Program completed ===");
        
        System.out.println("\n" + "=".repeat(50));
        System.out.println("Student: 24CE064 HEET MEHTA");
        System.out.println("=".repeat(50));
    }
}
