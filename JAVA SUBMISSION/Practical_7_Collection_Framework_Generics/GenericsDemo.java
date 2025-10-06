class Box<T> {
    private T item;
    
    public void setItem(T item) {
        this.item = item;
    }
    
    public T getItem() {
        return item;
    }
    
    public void displayType() {
        System.out.println("Type: " + item.getClass().getName());
    }
}

class Pair<K, V> {
    private K key;
    private V value;
    
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
    
    public K getKey() {
        return key;
    }
    
    public V getValue() {
        return value;
    }
    
    @Override
    public String toString() {
        return "Pair{key=" + key + ", value=" + value + "}";
    }
}

public class GenericsDemo {
    
    // Generic method
    public static <T> void printArray(T[] array) {
        System.out.print("Array: [");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    
    // Generic method with bounded type parameter
    public static <T extends Number> double sum(T num1, T num2) {
        return num1.doubleValue() + num2.doubleValue();
    }
    
    public static void demonstrateGenericClass() {
        System.out.println("=== Generic Class Demonstration ===\n");
        
        // Box with Integer
        Box<Integer> intBox = new Box<>();
        intBox.setItem(100);
        System.out.println("Integer Box: " + intBox.getItem());
        intBox.displayType();
        
        System.out.println();
        
        // Box with String
        Box<String> strBox = new Box<>();
        strBox.setItem("Hello Generics");
        System.out.println("String Box: " + strBox.getItem());
        strBox.displayType();
        
        System.out.println();
        
        // Box with Double
        Box<Double> doubleBox = new Box<>();
        doubleBox.setItem(99.99);
        System.out.println("Double Box: " + doubleBox.getItem());
        doubleBox.displayType();
        
        System.out.println();
    }
    
    public static void demonstrateMultipleTypeParameters() {
        System.out.println("=== Multiple Type Parameters ===\n");
        
        Pair<String, Integer> studentInfo = new Pair<>("Heet Mehta", 64);
        System.out.println(studentInfo);
        System.out.println("Name: " + studentInfo.getKey());
        System.out.println("Roll Number: " + studentInfo.getValue());
        
        System.out.println();
        
        Pair<Integer, String> courseInfo = new Pair<>(203, "OOPJ");
        System.out.println(courseInfo);
        
        System.out.println();
    }
    
    public static void demonstrateGenericMethod() {
        System.out.println("=== Generic Method Demonstration ===\n");
        
        Integer[] intArray = {1, 2, 3, 4, 5};
        String[] strArray = {"Java", "Python", "C++", "JavaScript"};
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4};
        
        System.out.println("Integer Array:");
        printArray(intArray);
        
        System.out.println("\nString Array:");
        printArray(strArray);
        
        System.out.println("\nDouble Array:");
        printArray(doubleArray);
        
        System.out.println();
    }
    
    public static void demonstrateBoundedTypeParameter() {
        System.out.println("=== Bounded Type Parameter ===\n");
        
        System.out.println("Sum of 10 and 20: " + sum(10, 20));
        System.out.println("Sum of 15.5 and 24.5: " + sum(15.5, 24.5));
        System.out.println("Sum of 100L and 200L: " + sum(100L, 200L));
        
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("=== Java Generics Demonstration ===\n");
        
        demonstrateGenericClass();
        demonstrateMultipleTypeParameters();
        demonstrateGenericMethod();
        demonstrateBoundedTypeParameter();
        
        System.out.println("=== Generics demonstration completed ===");
        
        System.out.println("\n" + "=".repeat(50));
        System.out.println("Student: 24CE064 HEET MEHTA");
        System.out.println("=".repeat(50));
    }
}
