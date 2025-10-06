public class ThreadPriorityDemo extends Thread {
    
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread name: " + Thread.currentThread().getName());
            System.out.println("Thread priority: " + Thread.currentThread().getPriority());
            System.out.println("Thread ID: " + Thread.currentThread().threadId());
            System.out.println("Iteration: " + (i + 1));
            System.out.println("---");
            
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Thread Priority Demonstration ===\n");
        
        ThreadPriorityDemo t1 = new ThreadPriorityDemo();
        ThreadPriorityDemo t2 = new ThreadPriorityDemo();
        ThreadPriorityDemo t3 = new ThreadPriorityDemo();
        
        t1.setName("Low-Priority-Thread");
        t2.setName("Normal-Priority-Thread");
        t3.setName("High-Priority-Thread");
        
        // Setting priorities
        t1.setPriority(Thread.MIN_PRIORITY);    // Priority: 1
        t2.setPriority(Thread.NORM_PRIORITY);   // Priority: 5
        t3.setPriority(Thread.MAX_PRIORITY);    // Priority: 10
        
        System.out.println("Starting threads with different priorities...\n");
        
        t1.start();
        t2.start();
        t3.start();
        
        System.out.println("\nMain thread priority: " + Thread.currentThread().getPriority());
        
        System.out.println("\n" + "=".repeat(50));
        System.out.println("Student: 24CE064 HEET MEHTA");
        System.out.println("=".repeat(50));
    }
}
