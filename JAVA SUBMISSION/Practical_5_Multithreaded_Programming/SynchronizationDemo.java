class BankAccount {
    private int balance = 1000;
    
    // Synchronized method
    public synchronized void withdraw(int amount, String customerName) {
        System.out.println(customerName + " is trying to withdraw $" + amount);
        
        if (balance >= amount) {
            System.out.println(customerName + " - Current balance: $" + balance);
            
            try {
                Thread.sleep(100); // Simulate processing time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            balance -= amount;
            System.out.println(customerName + " - Withdrawal successful!");
            System.out.println(customerName + " - New balance: $" + balance);
        } else {
            System.out.println(customerName + " - Insufficient balance!");
        }
        System.out.println("---");
    }
    
    public int getBalance() {
        return balance;
    }
}

class Customer extends Thread {
    private BankAccount account;
    private int withdrawAmount;
    private String customerName;
    
    public Customer(BankAccount account, int amount, String name) {
        this.account = account;
        this.withdrawAmount = amount;
        this.customerName = name;
    }
    
    @Override
    public void run() {
        account.withdraw(withdrawAmount, customerName);
    }
}

public class SynchronizationDemo {
    public static void main(String[] args) {
        System.out.println("=== Thread Synchronization Demonstration ===\n");
        
        BankAccount account = new BankAccount();
        System.out.println("Initial balance: $" + account.getBalance());
        System.out.println("\nMultiple customers trying to withdraw simultaneously...\n");
        
        // Multiple customers trying to withdraw from same account
        Customer c1 = new Customer(account, 600, "Customer-1");
        Customer c2 = new Customer(account, 500, "Customer-2");
        Customer c3 = new Customer(account, 400, "Customer-3");
        
        c1.start();
        c2.start();
        c3.start();
        
        try {
            c1.join();
            c2.join();
            c3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("\nFinal balance: $" + account.getBalance());
        
        System.out.println("\n" + "=".repeat(50));
        System.out.println("Student: 24CE064 HEET MEHTA");
        System.out.println("=".repeat(50));
    }
}
