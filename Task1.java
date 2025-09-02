/*Today's Lecture Task
Task1: Create a BankAccount class with a double balance field and two methods:
deposit(double amount)
withdraw(double amount)
In your main method, start at least three threads. Each thread should:
Deposit a certain amount
Withdraw another amount
Repeat a few times, logging each operation and the current balance
After all threads finish, print the final balance.  */

class BankAccount {
  private double balance;

  public BankAccount(double initialBalance) {
    this.balance = initialBalance;
  }

  public void deposit(double amount) {
    balance += amount;
    System.out.printf("%s deposited %.2f | Balance: %.2f\n", Thread.currentThread().getName(), amount, balance);
  }

  public void withdraw(double amount) {
    if (balance >= amount) {
      balance -= amount;
      System.out.printf("%s withdraw %.2f | Balance: %.2f\n", Thread.currentThread().getName(), amount, balance);
    } else {
      System.out.printf("%s tried to withdraw %.2f | Insufficient funds! Balance: %.2f\n", Thread.currentThread().getName(), amount, balance);
    }
  }

  public double getBalance() {
    return balance;
  }
}

class AccountWorker implements Runnable {
  private final BankAccount account;
  private final double depositAmount;
  private final double withdrawAmount;
  private final int repeat;

  public AccountWorker(BankAccount account, double depositAmount, double withdrawAmount, int repeat) {
    this.account = account;
    this.depositAmount = depositAmount;
    this.withdrawAmount = withdrawAmount;
    this.repeat = repeat;
  }

  @Override
  public void run() {
    for (int i = 0; i < repeat; i++) {
      account.deposit(depositAmount);
      try { Thread.sleep(100); } catch (InterruptedException e) { }
      account.withdraw(withdrawAmount);
      try { Thread.sleep(100); } catch (InterruptedException e) { }
    }
  }
}

public class Task1 {
  public static void main(String[] args) {
    BankAccount account = new BankAccount(10.0); 
    Thread t1 = new Thread(new AccountWorker(account, 20, 15, 1), "User 1");
    Thread t2 = new Thread(new AccountWorker(account, 30, 10, 1), "User 2");
    Thread t3 = new Thread(new AccountWorker(account, 15, 20, 1), "User 3");

    t1.start();
         
        
        try {
            t1.join(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
        //start third thread only when first thread is dead
        try {
            if(t1.isAlive()){
            System.out.println("Thread T1 is alive");
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
            System.out.println("Thread T1  is alive");
                t1.join();
            }
            if(t2.isAlive()){
                System.out.println("Thread T2  is alive");
                t2.join();
            }   
            if(t3.isAlive()){
                System.out.println("Thread T3  is alive");
                t3.join();
            }
        }
         catch (InterruptedException e) {
                  e.printStackTrace();
        }
         
        System.out.println("All threads are dead, exiting main thread");
         System.out.printf("Final balance: " + account.getBalance());
    }

   
  }
