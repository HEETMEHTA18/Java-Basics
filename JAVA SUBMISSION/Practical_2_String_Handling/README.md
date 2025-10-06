# Practical 2: String Handling

## AIM
To understand and implement String handling in Java including:
- String class methods and operations
- String comparison (== vs equals())
- String immutability and String pool
- StringBuffer and StringBuilder
- StringTokenizer for parsing strings

## Programs Included

### 1. StringOperations.java
Demonstrates:
- String creation (literal vs new keyword)
- String comparison methods (==, equals(), equalsIgnoreCase())
- String manipulation (substring, replace, trim)
- Character operations (charAt, indexOf, lastIndexOf)
- String methods (toUpperCase, toLowerCase, contains, split)
- StringBuffer operations

### 2. StringTokenizerDemo.java
Demonstrates:
- Tokenizing strings using default delimiter
- Using custom delimiters
- Counting and iterating through tokens

## How to Compile and Run

### For StringOperations.java:
```powershell
javac StringOperations.java
java StringOperations
```

### For StringTokenizerDemo.java:
```powershell
javac StringTokenizerDemo.java
java StringTokenizerDemo
```

## Expected Output

### StringOperations.java Output:
```
=== String Handling Demonstration ===

--- String Comparison ---
s1 == s2: false
s1 == s3: false
s1.equals(s3): false
s1.equals(s2): false
s2.equals(s4): true
s1.intern() == s3.intern(): false

--- Character Operations ---
charAt(0): H
charAt(2): e
indexOf('e'): 1
lastIndexOf('e'): 2

--- String Methods ---
Length: 10
Substring(5,10): Mehta
Contains('HeetMehta'): false
equalsIgnoreCase('heet mehta'): true
toUpperCase(): HEET MEHTA
toLowerCase(): heet mehta
Original: '  Hello Java  '
After trim(): 'Hello Java'

--- String Manipulation ---
indexOf('Java'): 6
replace('Java', 'World'): Hello World
Split 'A,B,C': A B C 

--- StringBuffer Demo ---
Original: Hello
After append: Hello World
After reverse: dlroW olleH
```

### StringTokenizerDemo.java Output:
```
=== StringTokenizer Demonstration ===

Original String: Java is fun and powerful
Token Count: 5

Tokens:
Token 1: Java
Token 2: is
Token 3: fun
Token 4: and
Token 5: powerful

--- Custom Delimiter Example ---
CSV String: Apple,Orange,Banana,Mango
Fruits:
  - Apple
  - Orange
  - Banana
  - Mango
```

## Key Concepts Covered
1. **String Immutability**: Strings cannot be modified once created
2. **String Pool**: String literals are stored in string pool for memory efficiency
3. **String Comparison**: Difference between == and equals()
4. **String Methods**: charAt, indexOf, substring, replace, trim, split
5. **StringBuffer**: Mutable string class for efficient string manipulation
6. **StringTokenizer**: Parsing strings with delimiters

## Screenshot Placeholder
📸 **[Insert screenshot of program output here]**

---
**Date Completed**: __________  
**Student Name**: Heet Mehta  
**Roll Number**: __________
