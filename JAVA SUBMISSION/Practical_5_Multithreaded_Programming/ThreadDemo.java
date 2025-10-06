class NumberPrinter extends Thread {
    private String threadName;
    
    public NumberPrinter(String name) {
        this.threadName = name;
        setName(name);
    }
    
    @Override
    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                System.out.println(threadName + " prints: " + i);
                Thread.sleep(500);  // Sleep for 500ms
            }
            System.out.println(threadName + " completed!");
        } catch (InterruptedException e) {
            System.err.println(threadName + " interrupted");
        }
    }
}

class LetterPrinter implements Runnable {
    private String threadName;
    
    public LetterPrinter(String name) {
        this.threadName = name;
    }
    
    @Override
    public void run() {
        try {
            char[] letters = {'A', 'B', 'C', 'D', 'E'};
            for (char letter : letters) {
                System.out.println(threadName + " prints: " + letter);
                Thread.sleep(500);
            }
            System.out.println(threadName + " completed!");
        } catch (InterruptedException e) {
            System.err.println(threadName + " interrupted");
        }
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
        System.out.println("=== Multithreading Demonstration ===\n");
        System.out.println("Main thread: " + Thread.currentThread().getName());
        
        // Creating thread by extending Thread class
        NumberPrinter numThread = new NumberPrinter("NumberThread");
        
        // Creating thread by implementing Runnable interface
        Thread letterThread = new Thread(new LetterPrinter("LetterThread"));
        
        System.out.println("\nStarting threads...\n");
        numThread.start();
        letterThread.start();
        
        try {
            // Wait for threads to complete
            numThread.join();
            letterThread.join();
        } catch (InterruptedException e) {
            System.err.println("Main thread interrupted");
        }
        
        System.out.println("\nAll threads completed!");
        System.out.println("Main thread exiting...");
        
        System.out.println("\n" + "=".repeat(50));
        System.out.println("Student: 24CE064 HEET MEHTA");
        System.out.println("=".repeat(50));
    }
}
