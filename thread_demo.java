//package ThreadDemo;
public class thread_demo implements Runnable {
    thread_demo(String name) {

    }
    public void run() {
        try{
            System.out.println("First thread name is :" + thread_demo.currentThread().getName());
           Thread. sleep(1000); // fixed to random from 1 to 2 seconds sequence
            System.out.println(thread_demo.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("In run method ,thread name is " + thread_demo.currentThread().getName());
    }

    public static void main(String[] args) {

        thread_demo d = new thread_demo();  // assignment : 10 array of the thread
        Thread t = new Thread(d);
//        d.run();
//        t.run();
        t.start();
        System.out.println(d);
//        d.setName("My-thread");
//        d.start();
//        System.out.println(Thread.currentThread().getName() + "currently in " + d.getState());
        //..
}
}
