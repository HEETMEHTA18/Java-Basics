# Practical 3: Inheritance, Interfaces & Packages

## AIM
To understand and implement:
- Inheritance (single and multilevel)
- Abstract classes and methods
- Interfaces and multiple inheritance
- Final classes
- instanceof operator
- Method overriding
- Packages

## Programs Included

### 1. HospitalManagement.java
Demonstrates:
- Abstract classes (Staff, MedicalStaff)
- Abstract methods
- Inheritance hierarchy
- instanceof operator
- Final class (FinanceTeam)
- Downcasting

### 2. InstrumentDemo.java
Demonstrates:
- Abstract class hierarchy
- Method overriding
- Multilevel inheritance (Woodwind extends Wind)
- Polymorphism

### 3. InterfaceDemo.java
Demonstrates:
- Interface implementation
- Multiple interface inheritance
- Default methods in interfaces
- Static methods in interfaces
- Final variables

## How to Compile and Run

### For HospitalManagement.java:
```powershell
javac HospitalManagement.java
java HospitalManagement
```

### For InstrumentDemo.java:
```powershell
javac InstrumentDemo.java
java InstrumentDemo
```

### For InterfaceDemo.java:
```powershell
javac InterfaceDemo.java
java InterfaceDemo
```

## Expected Output

### HospitalManagement.java Output:
```
=== Hospital Management System ===

--- Staff Work Details ---
Doctor Dr. Heet Mehta diagnoses and treats patients.
Nurse Sister Radha provides patient care.
Admin Staff Mr. Sharma manages records and billing.

--- instanceof Operator Demo ---
Doctor Dr. Heet Mehta is attending to a patient.
Nurse Sister Radha is assisting a patient.

--- Final Class Usage ---
Finance team is generating salary reports.
```

### InstrumentDemo.java Output:
```
=== Musical Instrument Management ===

Wind instrument played
Instrument name: Wind
Wind instrument tuned properly

Percussion instrument played
Instrument name: Percussion
Percussion instrument tuned properly

Stringed instrument played
Instrument name: Stringed
Stringed instrument tuned properly

Woodwind instrument played
Instrument name: Woodwind
Wind instrument tuned properly

Brass instrument played
Instrument name: Brass
Wind instrument tuned properly
```

### InterfaceDemo.java Output:
```
=== Interface Demonstration ===

--- Institute Details ---
Institute Code: 101
Institute Name: Charusat University
Location: Charusat

--- Interface Methods ---
Displaying class information through interface
Institute name set to: CSPIT - Charusat
This is a default method in Student interface

--- Static Interface Method ---
Location: Charusat, Gandhinagar

--- Scholarship Eligibility ---
CGPA 8.5 eligible: true
CGPA 7.5 eligible: false
```

## Key Concepts Covered
1. **Abstract Classes**: Cannot be instantiated, can have abstract and concrete methods
2. **Inheritance**: Code reuse through parent-child relationships
3. **Interfaces**: Multiple inheritance, default and static methods (Java 8+)
4. **Final Classes**: Cannot be extended
5. **instanceof**: Runtime type checking
6. **Polymorphism**: Method overriding and dynamic method dispatch

## Screenshot Placeholder
📸 **[Insert screenshot of program output here]**

---
**Date Completed**: __________  
**Student Name**: Heet Mehta  
**Roll Number**: __________
