// package ThreadDemo;

public class ThreadPriority extends Thread {
 public void run(){
     for(int i=0;i<5;i++){
     System.out.println("running thread name is:"+Thread.currentThread().getName());  
	 System.out.println("running thread priority is:"+Thread.currentThread().getPriority()); 
     System.out.println("running thread ID is:"+Thread.currentThread().getId()); 
      try{
        Thread.sleep(100);
      }catch(Exception e){}
    
     }
  }  
 public static void main(String args[]){  
  
     ThreadPriority m1=new ThreadPriority();  
  
     ThreadPriority m2=new ThreadPriority();
       
     m1.setName("Thread-1");
	 m2.setName("Thread-2");

     m1.setPriority(Thread.MIN_PRIORITY);
     m2.setPriority(Thread.MAX_PRIORITY);

     m1.start();  
     m2.start();
   
 }     
}
