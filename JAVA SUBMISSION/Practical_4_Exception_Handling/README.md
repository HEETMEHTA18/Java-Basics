# Practical 4: Exception Handling

## AIM
To understand and implement exception handling in Java including:
- Try-catch blocks
- Multiple catch blocks
- Finally block
- Throw and throws keywords
- Custom exceptions
- Nested try-catch blocks
- Built-in exceptions

## Programs Included

### 1. ExceptionHandlingDemo.java
Demonstrates:
- ArithmeticException (division by zero)
- ArrayIndexOutOfBoundsException
- NullPointerException
- NumberFormatException
- Multiple catch blocks
- Finally block
- Custom exception (InvalidAgeException)
- throws keyword

### 2. NestedTryCatchDemo.java
Demonstrates:
- Nested try-catch blocks
- Exception propagation
- Multiple exception handling in nested structure

## How to Compile and Run

### For ExceptionHandlingDemo.java:
```powershell
javac ExceptionHandlingDemo.java
java ExceptionHandlingDemo
```

### For NestedTryCatchDemo.java:
```powershell
javac NestedTryCatchDemo.java
java NestedTryCatchDemo
```

## Expected Output

### ExceptionHandlingDemo.java Output:
```
=== Exception Handling Demonstration ===

--- Arithmetic Exception Demo ---
Error: Cannot divide by zero!
Exception: / by zero

--- Array Index Out of Bounds Exception Demo ---
Error: Array index out of bounds!
Exception: Index 5 out of bounds for length 3

--- Null Pointer Exception Demo ---
Error: Null pointer exception!
Cannot call method on null object

--- Multiple Catch Blocks Demo ---
Error: Invalid number format!

--- Finally Block Demo ---
Inside try block
Result: 5
Finally block always executes!

--- Custom Exception Demo ---
Enter your age: 15
Custom Exception Caught: Age must be 18 or above. Given age: 15

--- Throws Keyword Demo ---
This method declares that it can throw ArithmeticException
Result: 20

=== Program completed successfully ===
```

### NestedTryCatchDemo.java Output:
```
=== Nested Try-Catch Demonstration ===

Outer try block started
Inner try block started
Element at index 1: 2
Inner catch: Arithmetic Exception caught!
Message: / by zero

Back to outer try block
Outer catch: Array Index Exception caught!
Message: Index 10 out of bounds for length 3

Outer finally block executed

=== Program completed ===
```

## Key Concepts Covered
1. **Try-Catch**: Basic exception handling mechanism
2. **Multiple Catch**: Handling different exception types
3. **Finally**: Code that always executes regardless of exception
4. **Throw**: Explicitly throwing exceptions
5. **Throws**: Declaring exceptions in method signature
6. **Custom Exceptions**: Creating user-defined exceptions
7. **Nested Try-Catch**: Exception handling in nested blocks
8. **Built-in Exceptions**: ArithmeticException, NullPointerException, etc.

## Exception Hierarchy
```
Throwable
├── Error (System errors - not to be handled)
└── Exception
    ├── RuntimeException (Unchecked)
    │   ├── ArithmeticException
    │   ├── NullPointerException
    │   ├── ArrayIndexOutOfBoundsException
    │   └── NumberFormatException
    └── Checked Exceptions
        └── Custom Exceptions (InvalidAgeException)
```

## Screenshot Placeholder
📸 **[Insert screenshot of program output here]**

---
**Date Completed**: __________  
**Student Name**: Heet Mehta  
**Roll Number**: __________
