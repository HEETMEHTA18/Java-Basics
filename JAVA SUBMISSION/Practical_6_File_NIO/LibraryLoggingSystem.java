import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

class Book {
    String bookId;
    String title;
    String author;
    
    public Book(String bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }
    
    @Override
    public String toString() {
        return bookId + " - " + title + " by " + author;
    }
}

class LogEntry {
    String timestamp;
    String action;
    String bookId;
    String bookTitle;
    String memberName;
    
    public LogEntry(String action, String bookId, String bookTitle, String memberName) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.timestamp = sdf.format(new Date());
        this.action = action;
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.memberName = memberName;
    }
    
    public String toLogString() {
        return String.format("[%s] %s | Book ID: %s | Title: %s | Member: %s",
                           timestamp, action, bookId, bookTitle, memberName);
    }
}

public class LibraryLoggingSystem {
    private static final String LOG_FILE = "library_logs.txt";
    private static List<Book> availableBooks = new ArrayList<>();
    private static List<Book> issuedBooks = new ArrayList<>();
    
    public static void initializeBooks() {
        availableBooks.add(new Book("B001", "Java Programming", "James Gosling"));
        availableBooks.add(new Book("B002", "Data Structures", "Robert Sedgewick"));
        availableBooks.add(new Book("B003", "Algorithms", "Thomas Cormen"));
        availableBooks.add(new Book("B004", "Clean Code", "Robert Martin"));
        availableBooks.add(new Book("B005", "Design Patterns", "Gang of Four"));
    }
    
    public static void logToFile(LogEntry entry) {
        try (FileWriter fw = new FileWriter(LOG_FILE, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            
            out.println(entry.toLogString());
            
        } catch (IOException e) {
            System.err.println("Error writing to log file: " + e.getMessage());
        }
    }
    
    public static void issueBook(String bookId, String memberName) {
        Book book = findBookInList(availableBooks, bookId);
        
        if (book != null) {
            availableBooks.remove(book);
            issuedBooks.add(book);
            
            LogEntry entry = new LogEntry("ISSUE", book.bookId, book.title, memberName);
            logToFile(entry);
            
            System.out.println("\n✓ Book issued successfully!");
            System.out.println("Book: " + book);
            System.out.println("Member: " + memberName);
            System.out.println("Log entry created.");
        } else {
            System.out.println("\n✗ Book not available or already issued!");
        }
    }
    
    public static void returnBook(String bookId, String memberName) {
        Book book = findBookInList(issuedBooks, bookId);
        
        if (book != null) {
            issuedBooks.remove(book);
            availableBooks.add(book);
            
            LogEntry entry = new LogEntry("RETURN", book.bookId, book.title, memberName);
            logToFile(entry);
            
            System.out.println("\n✓ Book returned successfully!");
            System.out.println("Book: " + book);
            System.out.println("Member: " + memberName);
            System.out.println("Log entry created.");
        } else {
            System.out.println("\n✗ Book was not issued or invalid Book ID!");
        }
    }
    
    private static Book findBookInList(List<Book> list, String bookId) {
        for (Book book : list) {
            if (book.bookId.equals(bookId)) {
                return book;
            }
        }
        return null;
    }
    
    public static void displayAvailableBooks() {
        System.out.println("\n=== Available Books ===");
        if (availableBooks.isEmpty()) {
            System.out.println("No books available.");
        } else {
            for (Book book : availableBooks) {
                System.out.println(book);
            }
        }
    }
    
    public static void displayIssuedBooks() {
        System.out.println("\n=== Issued Books ===");
        if (issuedBooks.isEmpty()) {
            System.out.println("No books issued.");
        } else {
            for (Book book : issuedBooks) {
                System.out.println(book);
            }
        }
    }
    
    public static void displayLogs() {
        System.out.println("\n=== Library Activity Logs ===");
        try (BufferedReader reader = new BufferedReader(new FileReader(LOG_FILE))) {
            String line;
            int count = 0;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                count++;
            }
            if (count == 0) {
                System.out.println("No logs available.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("No logs available yet.");
        } catch (IOException e) {
            System.err.println("Error reading log file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Library Logging System ===\n");
        
        initializeBooks();
        
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        
        while (running) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Display Available Books");
            System.out.println("2. Display Issued Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. View Logs");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    displayAvailableBooks();
                    break;
                case 2:
                    displayIssuedBooks();
                    break;
                case 3:
                    System.out.print("Enter Book ID: ");
                    String issueBookId = scanner.nextLine();
                    System.out.print("Enter Member Name: ");
                    String issueMember = scanner.nextLine();
                    issueBook(issueBookId, issueMember);
                    break;
                case 4:
                    System.out.print("Enter Book ID: ");
                    String returnBookId = scanner.nextLine();
                    System.out.print("Enter Member Name: ");
                    String returnMember = scanner.nextLine();
                    returnBook(returnBookId, returnMember);
                    break;
                case 5:
                    displayLogs();
                    break;
                case 6:
                    running = false;
                    System.out.println("\nThank you for using Library Logging System!");
                    break;
                default:
                    System.out.println("\nInvalid choice! Please try again.");
            }
        }
        
        System.out.println("\n" + "=".repeat(50));
        System.out.println("Student: 24CE064 HEET MEHTA");
        System.out.println("=".repeat(50));
        
        scanner.close();
    }
}
