package Code;
class ThreadClass extends Thread {
    public void run() {
        System.out.println("Thread is running: " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        ThreadClass thread1 = new ThreadClass();
        thread1.setName("CustomThread-1");
        thread1.start();

        ThreadClass thread2 = new ThreadClass();
        thread2.setName("CustomThread-2");
        thread2.start();
    }
}
