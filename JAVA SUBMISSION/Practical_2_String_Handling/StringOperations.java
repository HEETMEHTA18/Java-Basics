// StringOperations.java - Demonstrates String class methods and operations
public class StringOperations {
    public static void main(String[] args) {
        System.out.println("=== String Handling Demonstration ===\n");
        
        // String creation
        String s1 = "Heet Mehta";
        String s2 = "Heet";
        String s3 = new String("Heet");
        String s4 = s2;
        
        System.out.println("--- String Comparison ---");
        System.out.println("s1 == s2: " + (s1 == s2));
        System.out.println("s1 == s3: " + (s1 == s3));
        System.out.println("s1.equals(s3): " + s1.equals(s3));
        System.out.println("s1.equals(s2): " + s1.equals(s2));
        System.out.println("s2.equals(s4): " + s2.equals(s4));
        System.out.println("s1.intern() == s3.intern(): " + (s1.intern() == s3.intern()));
        
        System.out.println("\n--- Character Operations ---");
        System.out.println("charAt(0): " + s4.charAt(0));
        System.out.println("charAt(2): " + s4.charAt(2));
        System.out.println("indexOf('e'): " + s4.indexOf('e'));
        System.out.println("lastIndexOf('e'): " + s4.lastIndexOf('e'));
        
        System.out.println("\n--- String Methods ---");
        System.out.println("Length: " + s1.length());
        System.out.println("Substring(5,10): " + s1.substring(5, 10));
        System.out.println("Contains('HeetMehta'): " + s1.contains("HeetMehta"));
        System.out.println("equalsIgnoreCase('heet mehta'): " + s1.equalsIgnoreCase("heet mehta"));
        System.out.println("toUpperCase(): " + s1.toUpperCase());
        System.out.println("toLowerCase(): " + s1.toLowerCase());
        
        String s5 = "  Hello Java  ";
        System.out.println("Original: '" + s5 + "'");
        System.out.println("After trim(): '" + s5.trim() + "'");
        
        System.out.println("\n--- String Manipulation ---");
        String str = "Hello Java";
        System.out.println("indexOf('Java'): " + str.indexOf("Java"));
        System.out.println("replace('Java', 'World'): " + str.replace("Java", "World"));
        
        String[] parts = "A,B,C".split(",");
        System.out.print("Split 'A,B,C': ");
        for (String part : parts) {
            System.out.print(part + " ");
        }
        System.out.println();
        
        System.out.println("\n--- StringBuffer Demo ---");
        StringBuffer sb = new StringBuffer("Hello");
        System.out.println("Original: " + sb);
        sb.append(" World");
        System.out.println("After append: " + sb);
        sb.reverse();
        System.out.println("After reverse: " + sb);
        
        System.out.println("\n" + "=".repeat(50));
        System.out.println("Student: 24CE064 HEET MEHTA");
        System.out.println("=".repeat(50));
    }
}
