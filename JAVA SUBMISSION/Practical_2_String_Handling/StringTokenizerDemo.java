// StringTokenizerDemo.java - Demonstrates StringTokenizer class
import java.util.StringTokenizer;

public class StringTokenizerDemo {
    public static void main(String[] args) {
        System.out.println("=== StringTokenizer Demonstration ===\n");
        
        String text = "Java is fun and powerful";
        StringTokenizer st = new StringTokenizer(text);
        
        System.out.println("Original String: " + text);
        System.out.println("Token Count: " + st.countTokens());
        System.out.println("\nTokens:");
        
        int tokenNumber = 1;
        while (st.hasMoreTokens()) {
            System.out.println("Token " + tokenNumber + ": " + st.nextToken());
            tokenNumber++;
        }
        
        System.out.println("\n--- Custom Delimiter Example ---");
        String csv = "Apple,Orange,Banana,Mango";
        StringTokenizer st2 = new StringTokenizer(csv, ",");
        
        System.out.println("CSV String: " + csv);
        System.out.println("Fruits:");
        while (st2.hasMoreTokens()) {
            System.out.println("  - " + st2.nextToken());
        }
        
        System.out.println("\n" + "=".repeat(50));
        System.out.println("Student: 24CE064 HEET MEHTA");
        System.out.println("=".repeat(50));
    }
}
