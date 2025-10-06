import java.util.*;

public class StudentIDManager {
    private static HashSet<Integer> hashSet = new HashSet<>();
    private static TreeSet<Integer> treeSet = new TreeSet<>();
    private static LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void addStudentID() {
        System.out.print("\nEnter Student ID to add: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        boolean addedToHash = hashSet.add(id);
        treeSet.add(id);
        linkedHashSet.add(id);
        
        if (addedToHash) {
            System.out.println("✓ Student ID " + id + " added successfully!");
        } else {
            System.out.println("✗ Student ID " + id + " already exists!");
        }
    }
    
    public static void removeStudentID() {
        if (hashSet.isEmpty()) {
            System.out.println("\nNo student IDs to remove.");
            return;
        }
        
        System.out.print("\nEnter Student ID to remove: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        boolean removed = hashSet.remove(id);
        treeSet.remove(id);
        linkedHashSet.remove(id);
        
        if (removed) {
            System.out.println("✓ Student ID " + id + " removed successfully!");
        } else {
            System.out.println("✗ Student ID " + id + " not found!");
        }
    }
    
    public static void checkStudentID() {
        System.out.print("\nEnter Student ID to check: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        if (hashSet.contains(id)) {
            System.out.println("✓ Student ID " + id + " exists in the system!");
        } else {
            System.out.println("✗ Student ID " + id + " does not exist!");
        }
    }
    
    public static void displayUnorderedIDs() {
        System.out.println("\n=== HashSet (Unordered) ===");
        
        if (hashSet.isEmpty()) {
            System.out.println("No student IDs available.");
            return;
        }
        
        System.out.println("Student IDs: " + hashSet);
        System.out.println("Total IDs: " + hashSet.size());
    }
    
    public static void displaySortedIDs() {
        System.out.println("\n=== TreeSet (Sorted Order) ===");
        
        if (treeSet.isEmpty()) {
            System.out.println("No student IDs available.");
            return;
        }
        
        System.out.println("Student IDs: " + treeSet);
        System.out.println("First ID: " + treeSet.first());
        System.out.println("Last ID: " + treeSet.last());
        System.out.println("Total IDs: " + treeSet.size());
    }
    
    public static void displayInsertionOrderIDs() {
        System.out.println("\n=== LinkedHashSet (Insertion Order) ===");
        
        if (linkedHashSet.isEmpty()) {
            System.out.println("No student IDs available.");
            return;
        }
        
        System.out.println("Student IDs: " + linkedHashSet);
        System.out.println("Total IDs: " + linkedHashSet.size());
    }
    
    public static void displayAllRepresentations() {
        System.out.println("\n=== All Representations ===");
        
        if (hashSet.isEmpty()) {
            System.out.println("No student IDs available.");
            return;
        }
        
        System.out.println("\n1. HashSet (Unordered):");
        System.out.println("   " + hashSet);
        
        System.out.println("\n2. TreeSet (Sorted):");
        System.out.println("   " + treeSet);
        
        System.out.println("\n3. LinkedHashSet (Insertion Order):");
        System.out.println("   " + linkedHashSet);
        
        System.out.println("\nTotal unique IDs: " + hashSet.size());
    }
    
    public static void displayMenu() {
        System.out.println("\n===== Student ID Management System =====");
        System.out.println("1. Add a new Student ID");
        System.out.println("2. Remove an existing ID");
        System.out.println("3. Check if a particular ID exists");
        System.out.println("4. Display all IDs:");
        System.out.println("   4.1) Unordered (HashSet) form");
        System.out.println("   4.2) Sorted (TreeSet) form");
        System.out.println("   4.3) Insertion order (LinkedHashSet) form");
        System.out.println("   4.4) All representations");
        System.out.println("5. Add sample data");
        System.out.println("6. Clear all data");
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");
    }
    
    public static void addSampleData() {
        int[] sampleIDs = {105, 102, 108, 101, 107, 103, 106, 104};
        
        for (int id : sampleIDs) {
            hashSet.add(id);
            treeSet.add(id);
            linkedHashSet.add(id);
        }
        
        System.out.println("\n✓ Sample data added successfully!");
        System.out.println("Added IDs: 105, 102, 108, 101, 107, 103, 106, 104");
    }
    
    public static void clearAllData() {
        hashSet.clear();
        treeSet.clear();
        linkedHashSet.clear();
        System.out.println("\n✓ All data cleared successfully!");
    }

    public static void main(String[] args) {
        System.out.println("===== Welcome to Student ID Management System =====");
        System.out.println("\nThis system demonstrates:");
        System.out.println("- HashSet: No duplicates, unordered");
        System.out.println("- TreeSet: No duplicates, sorted");
        System.out.println("- LinkedHashSet: No duplicates, maintains insertion order");
        
        boolean running = true;
        
        while (running) {
            displayMenu();
            
            String input = scanner.nextLine();
            
            switch (input) {
                case "1":
                    addStudentID();
                    break;
                case "2":
                    removeStudentID();
                    break;
                case "3":
                    checkStudentID();
                    break;
                case "4.1":
                    displayUnorderedIDs();
                    break;
                case "4.2":
                    displaySortedIDs();
                    break;
                case "4.3":
                    displayInsertionOrderIDs();
                    break;
                case "4.4":
                    displayAllRepresentations();
                    break;
                case "5":
                    addSampleData();
                    break;
                case "6":
                    clearAllData();
                    break;
                case "7":
                    running = false;
                    System.out.println("\nThank you for using Student ID Management System!");
                    break;
                default:
                    System.out.println("\n✗ Invalid choice! Please try again.");
            }
        }
        
        System.out.println("\n" + "=".repeat(50));
        System.out.println("Student: 24CE064 HEET MEHTA");
        System.out.println("=".repeat(50));
        
        scanner.close();
    }
}
