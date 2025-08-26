// package ThreadDemo;
public class ThreadJoinEx {
 
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyRunnable(), "t1");
        Thread t2 = new Thread(new MyRunnable(), "t2");
        Thread t3 = new Thread(new MyRunnable(), "t3");
         
        t1.start();
         
        //start second thread after waiting for 5 seconds or if it's dead
        try {
            t1.join(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
        //start third thread only when first thread is dead
        try {
            if(t1.isAlive()){
            System.out.println("t1 is alive");
                t1.join();
            }
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
         
        t3.start();
         
        //let all threads finish execution before finishing main thread
        try {
            if(t1.isAlive()){
            System.out.println("t1 is alive");
                t1.join();
            }
            if(t2.isAlive()){
                System.out.println("t2 is alive");
                t2.join();
            }
            if(t3.isAlive()){
                System.out.println("t3 is alive");
                t3.join(); 
			}
        }
         catch (InterruptedException e) {
                  e.printStackTrace();
        }
         
        System.out.println("All threads are dead, exiting main thread");
    }
 
}
 
class MyRunnable implements Runnable{
 
    @Override
    public void run() {
        System.out.println("Thread started:::"+Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread ended:::"+Thread.currentThread().getName());
    }
     
}