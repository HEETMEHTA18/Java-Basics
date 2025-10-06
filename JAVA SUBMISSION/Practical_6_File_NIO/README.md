# Practical 6: File I/O and NIO

## AIM
To understand and implement file operations in Java including:
- Reading and writing text files
- File manipulation (copy, append)
- File information retrieval
- Object serialization and deserialization
- Stream classes (FileInputStream, FileOutputStream)
- Character streams (FileReader, FileWriter, BufferedReader)

## Programs Included

### 1. FileIODemo.java
Demonstrates:
- Writing to files using FileWriter
- Reading from files using BufferedReader
- Appending content to files
- Copying files using byte streams
- Retrieving file information
- Try-with-resources for automatic resource management

### 2. SerializationDemo.java
Demonstrates:
- Object serialization (saving objects to files)
- Object deserialization (reading objects from files)
- Serializable interface
- transient keyword
- ObjectOutputStream and ObjectInputStream

### 3. StudentGradeReport.java
Demonstrates:
- **CSV File Reading**: Reads student marks from input file
- **Grade Calculation**: Computes average and assigns grades (A+ to F)
- **Report Generation**: Creates formatted student reports
- **Grading System**: A+ (≥90), A (≥80), B (≥70), C (≥60), D (≥50), F (<50)
- File I/O for data processing

### 4. LibraryLoggingSystem.java
Demonstrates:
- **Book Management System**: Issue and return operations
- **Timestamp Logging**: Records all transactions with date/time
- **File Logging**: Maintains library_logs.txt
- **Menu-driven Interface**: User-friendly console application
- Practical logging system implementation

### 5. ExpenseTracker.java
Demonstrates:
- **Daily Expense Recording**: Date, category, amount, description
- **Category Management**: Food, Transport, Shopping, Bills, Entertainment, Others
- **Monthly Summaries**: Category-wise expense reports
- **File Persistence**: Auto-saves expenses and summaries
- Practical personal finance application

### 6. WordFrequencyCounter.java
Demonstrates:
- **Text File Analysis**: Reads and processes text files
- **HashMap Word Counting**: Frequency analysis
- **Sorting**: Orders by frequency (descending)
- **Top 10 Display**: Most frequent words
- File I/O for text analysis

## How to Compile and Run

### For FileIODemo.java:
```powershell
javac FileIODemo.java
java FileIODemo
```

### For SerializationDemo.java:
```powershell
javac SerializationDemo.java
java SerializationDemo
```

## Expected Output

### FileIODemo.java Output:
```
=== File I/O Operations Demonstration ===

--- Writing to File ---
✓ Content written to sample.txt

--- Reading from sample.txt ---
1: Hello, this is a test file.
2: Java File I/O is powerful!
3: Learning file operations in Java.

--- Appending to File ---
✓ Content appended to sample.txt

--- Reading from sample.txt ---
1: Hello, this is a test file.
2: Java File I/O is powerful!
3: Learning file operations in Java.
4: This line is appended.

--- Copying File ---
✓ File copied from sample.txt to copy_sample.txt

--- File Information ---
File name: sample.txt
Absolute path: [full path]/sample.txt
Exists: true
Readable: true
Writable: true
File size: 112 bytes

=== File operations completed ===
```

### SerializationDemo.java Output:
```
=== Object Serialization Demonstration ===

--- Original Object ---
Student{name='Heet Mehta', rollNumber=64, department='Computer Engineering', password='secret123'}

--- Serialization ---
✓ Object serialized to student.ser
Serialized: Student{name='Heet Mehta', rollNumber=64, department='Computer Engineering', password='secret123'}

--- Deserialization ---
✓ Object deserialized from student.ser
Deserialized: Student{name='Heet Mehta', rollNumber=64, department='Computer Engineering', password='null'}

--- Note ---
Notice that the 'password' field is null after deserialization
because it was marked as 'transient'

=== Serialization demonstration completed ===
```

## Files Created by Programs
- `sample.txt` - Text file with sample content
- `copy_sample.txt` - Copy of sample.txt
- `student.ser` - Serialized Student object

## Key Concepts Covered
1. **Character Streams**: FileReader, FileWriter, BufferedReader
2. **Byte Streams**: FileInputStream, FileOutputStream
3. **File Operations**: Read, Write, Append, Copy
4. **File Class**: Accessing file metadata
5. **Serialization**: Converting objects to byte streams
6. **Transient Keyword**: Excluding fields from serialization
7. **Try-with-resources**: Automatic resource management

## Stream Hierarchy
```
InputStream / OutputStream (Byte Streams)
├── FileInputStream / FileOutputStream
└── ObjectInputStream / ObjectOutputStream

Reader / Writer (Character Streams)
├── FileReader / FileWriter
└── BufferedReader / BufferedWriter
```

## Screenshot Placeholder
📸 **[Insert screenshot of program output here]**

---
**Date Completed**: __________  
**Student Name**: Heet Mehta  
**Roll Number**: __________
