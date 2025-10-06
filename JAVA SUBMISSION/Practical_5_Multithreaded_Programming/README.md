# Practical 5: Multithreaded Programming

## AIM
To understand and implement multithreading in Java including:
- Thread creation using Thread class
- Thread creation using Runnable interface
- Thread lifecycle and states
- Thread priorities
- Thread synchronization
- Thread methods (start, run, sleep, join)

## Programs Included

### 1. ThreadDemo.java
Demonstrates:
- Creating threads by extending Thread class
- Creating threads by implementing Runnable interface
- Thread.sleep() method
- Thread.join() method
- Running multiple threads concurrently

### 2. ThreadPriorityDemo.java
Demonstrates:
- Setting thread priorities (MIN, NORM, MAX)
- Thread properties (name, ID, priority)
- Priority-based thread scheduling

### 3. SynchronizationDemo.java
Demonstrates:
- Race condition problem
- Synchronized method
- Thread safety
- Multiple threads accessing shared resource

### 4. BankAccountSimulation.java
Demonstrates:
- **Real-world Banking Simulation**: Deposit and withdrawal operations
- **Synchronized Methods**: Thread-safe banking transactions
- **Multiple Concurrent Transactions**: 3 deposit and 3 withdrawal threads
- **Balance Consistency**: Maintains accurate balance across threads
- Practical synchronization example

### 5. FileReaderThreads.java
Demonstrates:
- **Parallel File Reading**: Reads 3 files simultaneously
- **Thread-per-File Strategy**: Each file handled by separate thread
- **Concurrent I/O**: Demonstrates parallel file operations
- **Line Counting**: Counts lines in each file independently
- Performance benefits of multithreading

## How to Compile and Run

### For ThreadDemo.java:
```powershell
javac ThreadDemo.java
java ThreadDemo
```

### For ThreadPriorityDemo.java:
```powershell
javac ThreadPriorityDemo.java
java ThreadPriorityDemo
```

### For SynchronizationDemo.java:
```powershell
javac SynchronizationDemo.java
java SynchronizationDemo
```

## Expected Output

### ThreadDemo.java Output:
```
=== Multithreading Demonstration ===

Main thread: main

Starting threads...

NumberThread prints: 1
LetterThread prints: A
NumberThread prints: 2
LetterThread prints: B
NumberThread prints: 3
LetterThread prints: C
NumberThread prints: 4
LetterThread prints: D
NumberThread prints: 5
LetterThread prints: E
NumberThread completed!
LetterThread completed!

All threads completed!
Main thread exiting...
```

### ThreadPriorityDemo.java Output:
```
=== Thread Priority Demonstration ===

Starting threads with different priorities...

Main thread priority: 5
Thread name: High-Priority-Thread
Thread priority: 10
Thread ID: 15
Iteration: 1
---
Thread name: Normal-Priority-Thread
Thread priority: 5
Thread ID: 14
Iteration: 1
---
Thread name: Low-Priority-Thread
Thread priority: 1
Thread ID: 13
Iteration: 1
---
[...continues for 5 iterations each...]
```

### SynchronizationDemo.java Output:
```
=== Thread Synchronization Demonstration ===

Initial balance: ₹1000

Multiple customers trying to withdraw simultaneously...

Customer-1 is trying to withdraw ₹600
Customer-1 - Current balance: ₹1000
Customer-1 - Withdrawal successful!
Customer-1 - New balance: ₹400
---
Customer-2 is trying to withdraw ₹500
Customer-2 - Insufficient balance!
---
Customer-3 is trying to withdraw ₹400
Customer-3 - Current balance: ₹400
Customer-3 - Withdrawal successful!
Customer-3 - New balance: ₹0
---

Final balance: ₹0
```

## Key Concepts Covered
1. **Thread Creation**: Two ways - extending Thread class and implementing Runnable
2. **Thread Lifecycle**: New, Runnable, Running, Blocked, Dead
3. **Thread Methods**: start(), run(), sleep(), join()
4. **Thread Priority**: MIN_PRIORITY(1), NORM_PRIORITY(5), MAX_PRIORITY(10)
5. **Synchronization**: Preventing race conditions using synchronized keyword
6. **Thread Safety**: Protecting shared resources from concurrent access

## Thread Lifecycle Diagram
```
NEW → RUNNABLE → RUNNING → DEAD
         ↓          ↓
         ↓      BLOCKED
         ↓          ↑
         └──────────┘
```

## Screenshot Placeholder
📸 **[Insert screenshot of program output here]**

---
**Date Completed**: __________  
**Student Name**: Heet Mehta  
**Roll Number**: __________
