package Multithreading_Practicals.Practical1;
public class ThreadExample {
    // Thread extending Thread class
    static class NumberThread extends Thread {
        public void run() {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Number: " + i);
                try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
            }
        }
    }

    // Thread implementing Runnable
    static class LetterRunnable implements Runnable {
        public void run() {
            for (char c = 'A'; c <= 'E'; c++) {
                System.out.println("Letter: " + c);
                try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
            }
        }
    }

    public static void main(String[] args) {
        NumberThread t1 = new NumberThread();
        Thread t2 = new Thread(new LetterRunnable());
        t1.start();
        t2.start();
    }
}
