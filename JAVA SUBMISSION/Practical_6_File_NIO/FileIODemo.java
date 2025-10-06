import java.io.*;

public class FileIODemo {
    
    public static void writeToFile(String filename, String content) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(content);
            System.out.println("✓ Content written to " + filename);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
    
    public static void readFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            System.out.println("\n--- Reading from " + filename + " ---");
            String line;
            int lineNumber = 1;
            while ((line = reader.readLine()) != null) {
                System.out.println(lineNumber + ": " + line);
                lineNumber++;
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
    
    public static void appendToFile(String filename, String content) {
        try (FileWriter writer = new FileWriter(filename, true)) {
            writer.write(content);
            System.out.println("✓ Content appended to " + filename);
        } catch (IOException e) {
            System.err.println("Error appending to file: " + e.getMessage());
        }
    }
    
    public static void copyFile(String source, String destination) {
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(destination)) {
            
            byte[] buffer = new byte[1024];
            int bytesRead;
            
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            System.out.println("✓ File copied from " + source + " to " + destination);
        } catch (IOException e) {
            System.err.println("Error copying file: " + e.getMessage());
        }
    }
    
    public static void displayFileInfo(String filename) {
        File file = new File(filename);
        System.out.println("\n--- File Information ---");
        System.out.println("File name: " + file.getName());
        System.out.println("Absolute path: " + file.getAbsolutePath());
        System.out.println("Exists: " + file.exists());
        System.out.println("Readable: " + file.canRead());
        System.out.println("Writable: " + file.canWrite());
        System.out.println("File size: " + file.length() + " bytes");
    }

    public static void main(String[] args) {
        System.out.println("=== File I/O Operations Demonstration ===\n");
        
        String filename1 = "sample.txt";
        String filename2 = "copy_sample.txt";
        
        // Write to file
        System.out.println("--- Writing to File ---");
        String content = "Hello, this is a test file.\n" +
                        "Java File I/O is powerful!\n" +
                        "Learning file operations in Java.";
        writeToFile(filename1, content);
        
        // Read from file
        readFromFile(filename1);
        
        // Append to file
        System.out.println("\n--- Appending to File ---");
        appendToFile(filename1, "\nThis line is appended.");
        
        // Read updated file
        readFromFile(filename1);
        
        // Copy file
        System.out.println("\n--- Copying File ---");
        copyFile(filename1, filename2);
        
        // Display file info
        displayFileInfo(filename1);
        
        System.out.println("\n=== File operations completed ===");
        
        System.out.println("\n" + "=".repeat(50));
        System.out.println("Student: 24CE064 HEET MEHTA");
        System.out.println("=".repeat(50));
    }
}
