import java.io.*;

class FileLineCounter extends Thread {
    private String filename;
    private int lineCount;
    
    public FileLineCounter(String filename, String threadName) {
        super(threadName);
        this.filename = filename;
        this.lineCount = 0;
    }
    
    @Override
    public void run() {
        try {
            System.out.println(getName() + " started reading: " + filename);
            
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            
            while ((line = reader.readLine()) != null) {
                lineCount++;
                Thread.sleep(50);
            }
            
            reader.close();
            
            System.out.println(getName() + " finished!");
            System.out.println("File: " + filename + " | Lines: " + lineCount);
            System.out.println("---");
            
        } catch (FileNotFoundException e) {
            System.err.println(getName() + " - File not found: " + filename);
            System.err.println("Creating sample file...");
            createSampleFile();
        } catch (IOException e) {
            System.err.println(getName() + " - Error reading file: " + e.getMessage());
        } catch (InterruptedException e) {
            System.err.println(getName() + " - Thread interrupted");
        }
    }
    
    private void createSampleFile() {
        try {
            FileWriter writer = new FileWriter(filename);
            for (int i = 1; i <= 10; i++) {
                writer.write("This is line " + i + " of " + filename + "\n");
            }
            writer.close();
            System.out.println("Sample file created: " + filename);
        } catch (IOException e) {
            System.err.println("Error creating sample file: " + e.getMessage());
        }
    }
    
    public int getLineCount() {
        return lineCount;
    }
}

public class FileReaderThreads {
    public static void main(String[] args) {
        System.out.println("=== Multiple File Reader Using Threads ===\n");
        
        String file1 = "file1.txt";
        String file2 = "file2.txt";
        String file3 = "file3.txt";
        
        createSampleFiles(file1, file2, file3);
        
        FileLineCounter thread1 = new FileLineCounter(file1, "Thread-1");
        FileLineCounter thread2 = new FileLineCounter(file2, "Thread-2");
        FileLineCounter thread3 = new FileLineCounter(file3, "Thread-3");
        
        System.out.println("Starting all threads to read files simultaneously...\n");
        
        long startTime = System.currentTimeMillis();
        
        thread1.start();
        thread2.start();
        thread3.start();
        
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        long endTime = System.currentTimeMillis();
        
        System.out.println("\n=== Summary ===");
        System.out.println("Total lines in all files: " + 
                          (thread1.getLineCount() + thread2.getLineCount() + thread3.getLineCount()));
        System.out.println("Time taken: " + (endTime - startTime) + " ms");
        System.out.println("\n=== All threads completed ===");
        
        System.out.println("\n" + "=".repeat(50));
        System.out.println("Student: 24CE064 HEET MEHTA");
        System.out.println("=".repeat(50));
    }
    
    private static void createSampleFiles(String file1, String file2, String file3) {
        try {
            FileWriter writer1 = new FileWriter(file1);
            for (int i = 1; i <= 15; i++) {
                writer1.write("File 1 - Line " + i + ": Java Programming\n");
            }
            writer1.close();
            
            FileWriter writer2 = new FileWriter(file2);
            for (int i = 1; i <= 20; i++) {
                writer2.write("File 2 - Line " + i + ": Multithreading Concepts\n");
            }
            writer2.close();
            
            FileWriter writer3 = new FileWriter(file3);
            for (int i = 1; i <= 12; i++) {
                writer3.write("File 3 - Line " + i + ": Synchronization Demo\n");
            }
            writer3.close();
            
            System.out.println("Sample files created successfully!\n");
        } catch (IOException e) {
            System.err.println("Error creating sample files: " + e.getMessage());
        }
    }
}
