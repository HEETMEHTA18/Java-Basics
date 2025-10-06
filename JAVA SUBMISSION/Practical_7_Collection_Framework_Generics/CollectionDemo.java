import java.util.*;

public class CollectionDemo {
    
    public static void demonstrateArrayList() {
        System.out.println("=== ArrayList Demonstration ===");
        ArrayList<String> fruits = new ArrayList<>();
        
        // Adding elements
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Mango");
        fruits.add("Apple"); // Duplicates allowed
        
        System.out.println("ArrayList: " + fruits);
        System.out.println("Size: " + fruits.size());
        System.out.println("Element at index 2: " + fruits.get(2));
        System.out.println("Contains 'Banana': " + fruits.contains("Banana"));
        
        // Remove element
        fruits.remove("Orange");
        System.out.println("After removing Orange: " + fruits);
        
        // Iterate
        System.out.print("Iterating: ");
        for (String fruit : fruits) {
            System.out.print(fruit + " ");
        }
        System.out.println("\n");
    }
    
    public static void demonstrateHashSet() {
        System.out.println("=== HashSet Demonstration ===");
        HashSet<Integer> numbers = new HashSet<>();
        
        // Adding elements
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(20); // Duplicate - won't be added
        numbers.add(40);
        
        System.out.println("HashSet: " + numbers);
        System.out.println("Size: " + numbers.size());
        System.out.println("Contains 20: " + numbers.contains(20));
        
        // Remove element
        numbers.remove(30);
        System.out.println("After removing 30: " + numbers);
        System.out.println();
    }
    
    public static void demonstrateTreeSet() {
        System.out.println("=== TreeSet Demonstration ===");
        TreeSet<String> cities = new TreeSet<>();
        
        // Adding elements (automatically sorted)
        cities.add("Mumbai");
        cities.add("Delhi");
        cities.add("Bangalore");
        cities.add("Chennai");
        cities.add("Ahmedabad");
        
        System.out.println("TreeSet (sorted): " + cities);
        System.out.println("First: " + cities.first());
        System.out.println("Last: " + cities.last());
        System.out.println();
    }
    
    public static void demonstrateHashMap() {
        System.out.println("=== HashMap Demonstration ===");
        HashMap<Integer, String> students = new HashMap<>();
        
        // Adding key-value pairs
        students.put(101, "Heet Mehta");
        students.put(102, "Rahul Sharma");
        students.put(103, "Priya Patel");
        students.put(104, "Amit Kumar");
        
        System.out.println("HashMap: " + students);
        System.out.println("Size: " + students.size());
        System.out.println("Student with ID 102: " + students.get(102));
        System.out.println("Contains key 103: " + students.containsKey(103));
        
        // Iterate through entries
        System.out.println("\nIterating through entries:");
        for (Map.Entry<Integer, String> entry : students.entrySet()) {
            System.out.println("ID: " + entry.getKey() + ", Name: " + entry.getValue());
        }
        
        // Remove entry
        students.remove(104);
        System.out.println("\nAfter removing ID 104: " + students);
        System.out.println();
    }
    
    public static void demonstrateLinkedList() {
        System.out.println("=== LinkedList Demonstration ===");
        LinkedList<String> queue = new LinkedList<>();
        
        // Queue operations
        queue.addLast("First");
        queue.addLast("Second");
        queue.addLast("Third");
        queue.addFirst("Zero");
        
        System.out.println("LinkedList: " + queue);
        System.out.println("First element: " + queue.getFirst());
        System.out.println("Last element: " + queue.getLast());
        
        queue.removeFirst();
        System.out.println("After removing first: " + queue);
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("=== Java Collection Framework Demonstration ===\n");
        
        demonstrateArrayList();
        demonstrateHashSet();
        demonstrateTreeSet();
        demonstrateHashMap();
        demonstrateLinkedList();
        
        System.out.println("=== Collection demonstration completed ===");
        
        System.out.println("\n" + "=".repeat(50));
        System.out.println("Student: 24CE064 HEET MEHTA");
        System.out.println("=".repeat(50));
    }
}
