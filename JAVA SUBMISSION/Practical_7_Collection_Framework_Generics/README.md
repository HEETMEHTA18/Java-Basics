# Practical 7: Collection Framework and Generics

## AIM
To understand and implement:
- Java Collection Framework
- List, Set, Map interfaces
- ArrayList, LinkedList, HashSet, TreeSet, HashMap
- Generic classes and methods
- Bounded type parameters
- Type safety using generics

## Programs Included

### 1. CollectionDemo.java
Demonstrates:
- **ArrayList**: Dynamic array, allows duplicates
- **HashSet**: No duplicates, unordered
- **TreeSet**: No duplicates, sorted order
- **HashMap**: Key-value pairs
- **LinkedList**: Doubly-linked list, queue operations
- Common operations: add, remove, iterate, search

### 2. GenericsDemo.java
Demonstrates:
- Generic class with single type parameter
- Generic class with multiple type parameters (Pair)
- Generic methods
- Bounded type parameters (extends Number)
- Type safety and code reusability

### 3. ToDoListManager.java
Demonstrates:
- **ArrayList Operations**: Dynamic task storage
- **Menu-driven Interface**: Add, display, edit, delete tasks
- **Task Management**: Mark tasks as completed
- **Object-oriented Design**: Task class with properties
- Practical application of ArrayList

### 4. WordCounter.java
Demonstrates:
- **HashMap**: Fast word frequency counting (unordered)
- **LinkedHashMap**: Maintains insertion order of words
- **TreeMap**: Displays words in alphabetical order
- **Map Comparison**: Shows differences between Map types
- Word frequency analysis and sorting

### 5. StudentIDManager.java
Demonstrates:
- **HashSet**: Fast lookup, prevents duplicates (unordered)
- **TreeSet**: Sorted display of student IDs
- **LinkedHashSet**: Maintains insertion order
- **Set Operations**: Add, remove, check existence, display
- Menu-driven unique ID management system

## How to Compile and Run

### For CollectionDemo.java:
```powershell
javac CollectionDemo.java
java CollectionDemo
```

### For GenericsDemo.java:
```powershell
javac GenericsDemo.java
java GenericsDemo
```

## Expected Output

### CollectionDemo.java Output:
```
=== Java Collection Framework Demonstration ===

=== ArrayList Demonstration ===
ArrayList: [Apple, Banana, Orange, Mango, Apple]
Size: 5
Element at index 2: Orange
Contains 'Banana': true
After removing Orange: [Apple, Banana, Mango, Apple]
Iterating: Apple Banana Mango Apple 

=== HashSet Demonstration ===
HashSet: [20, 40, 10, 30]
Size: 4
Contains 20: true
After removing 30: [20, 40, 10]

=== TreeSet Demonstration ===
TreeSet (sorted): [Ahmedabad, Bangalore, Chennai, Delhi, Mumbai]
First: Ahmedabad
Last: Mumbai

=== HashMap Demonstration ===
HashMap: {101=Heet Mehta, 102=Rahul Sharma, 103=Priya Patel, 104=Amit Kumar}
Size: 4
Student with ID 102: Rahul Sharma
Contains key 103: true

Iterating through entries:
ID: 101, Name: Heet Mehta
ID: 102, Name: Rahul Sharma
ID: 103, Name: Priya Patel
ID: 104, Name: Amit Kumar

After removing ID 104: {101=Heet Mehta, 102=Rahul Sharma, 103=Priya Patel}

=== LinkedList Demonstration ===
LinkedList: [Zero, First, Second, Third]
First element: Zero
Last element: Third
After removing first: [First, Second, Third]

=== Collection demonstration completed ===
```

### GenericsDemo.java Output:
```
=== Java Generics Demonstration ===

=== Generic Class Demonstration ===

Integer Box: 100
Type: java.lang.Integer

String Box: Hello Generics
Type: java.lang.String

Double Box: 99.99
Type: java.lang.Double

=== Multiple Type Parameters ===

Pair{key=Heet Mehta, value=64}
Name: Heet Mehta
Roll Number: 64

Pair{key=203, value=OOPJ}

=== Generic Method Demonstration ===

Integer Array:
Array: [1, 2, 3, 4, 5]

String Array:
Array: [Java, Python, C++, JavaScript]

Double Array:
Array: [1.1, 2.2, 3.3, 4.4]

=== Bounded Type Parameter ===

Sum of 10 and 20: 30.0
Sum of 15.5 and 24.5: 40.0
Sum of 100L and 200L: 300.0

=== Generics demonstration completed ===
```

## Key Concepts Covered

### Collection Framework
1. **List Interface**: Ordered, allows duplicates (ArrayList, LinkedList)
2. **Set Interface**: Unordered, no duplicates (HashSet, TreeSet)
3. **Map Interface**: Key-value pairs (HashMap, TreeMap)
4. **Common Operations**: add, remove, contains, size, iterate

### Generics
1. **Generic Classes**: Type-safe containers
2. **Generic Methods**: Methods that work with different types
3. **Multiple Type Parameters**: Pair<K, V>
4. **Bounded Types**: <T extends Number>
5. **Type Safety**: Compile-time type checking

## Collection Hierarchy
```
Collection
├── List
│   ├── ArrayList
│   └── LinkedList
└── Set
    ├── HashSet
    └── TreeSet

Map
├── HashMap
└── TreeMap
```

## Benefits of Generics
- **Type Safety**: Compile-time type checking
- **Code Reusability**: Same code for different types
- **No Type Casting**: Eliminates need for explicit casting
- **Compile-time Errors**: Catches type errors early

## Screenshot Placeholder
📸 **[Insert screenshot of program output here]**

---
**Date Completed**: __________  
**Student Name**: Heet Mehta  
**Roll Number**: __________
