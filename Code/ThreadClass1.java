package Code;
class ThreadClass1 implements Runnable {
    public void run() {
        System.out.println("Thread is running: " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new ThreadClass1(), "CustomThread-1");
        Thread t2 = new Thread(new ThreadClass1(), "CustomThread-2");

        t1.start();
        t2.start();
    }
}

