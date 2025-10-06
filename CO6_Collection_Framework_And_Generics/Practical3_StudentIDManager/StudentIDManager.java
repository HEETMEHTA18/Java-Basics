import java.util.*;

public class StudentIDManager {
    static HashSet<Integer> hashSet = new HashSet<>();
    static LinkedHashSet<Integer> linkedSet = new LinkedHashSet<>();
    static TreeSet<Integer> treeSet = new TreeSet<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Student ID Manager ---");
            System.out.println("1. Add Student ID");
            System.out.println("2. Remove Student ID");
            System.out.println("3. Check Student ID");
            System.out.println("4. Display All IDs");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> addID();
                case 2 -> removeID();
                case 3 -> checkID();
                case 4 -> displayIDs();
                case 5 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid option!");
            }
        }
    }

    static void addID() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        if (hashSet.add(id)) {
            linkedSet.add(id);
            treeSet.add(id);
            System.out.println("ID added successfully.");
        } else {
            System.out.println("Duplicate ID! Not added.");
        }
    }

    static void removeID() {
        System.out.print("Enter Student ID to remove: ");
        int id = sc.nextInt();
        if (hashSet.remove(id)) {
            linkedSet.remove(id);
            treeSet.remove(id);
            System.out.println("ID removed successfully.");
        } else {
            System.out.println("ID not found.");
        }
    }

    static void checkID() {
        System.out.print("Enter Student ID to check: ");
        int id = sc.nextInt();
        System.out.println(hashSet.contains(id) ? "ID exists." : "ID does not exist.");
    }

    static void displayIDs() {
        System.out.println("\nUnordered (HashSet): " + hashSet);
        System.out.println("Insertion Order (LinkedHashSet): " + linkedSet);
        System.out.println("Sorted Order (TreeSet): " + treeSet);
    }
}
