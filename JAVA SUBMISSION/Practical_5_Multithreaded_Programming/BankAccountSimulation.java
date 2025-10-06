class BankAccount {
    private double balance;
    
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }
    
    public synchronized void deposit(double amount, String threadName) {
        System.out.println(threadName + " is depositing $" + amount);
        double oldBalance = balance;
        
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        balance += amount;
        System.out.println(threadName + " completed deposit. Old Balance: $" + oldBalance + 
                          " | New Balance: $" + balance);
        System.out.println("---");
    }
    
    public synchronized void withdraw(double amount, String threadName) {
        System.out.println(threadName + " is withdrawing $" + amount);
        
        if (balance >= amount) {
            double oldBalance = balance;
            
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            balance -= amount;
            System.out.println(threadName + " completed withdrawal. Old Balance: $" + oldBalance + 
                              " | New Balance: $" + balance);
        } else {
            System.out.println(threadName + " - Insufficient balance! Current Balance: $" + balance);
        }
        System.out.println("---");
    }
    
    public synchronized double getBalance() {
        return balance;
    }
}

class DepositThread extends Thread {
    private BankAccount account;
    private double amount;
    
    public DepositThread(BankAccount account, double amount, String name) {
        super(name);
        this.account = account;
        this.amount = amount;
    }
    
    @Override
    public void run() {
        account.deposit(amount, getName());
    }
}

class WithdrawalThread extends Thread {
    private BankAccount account;
    private double amount;
    
    public WithdrawalThread(BankAccount account, double amount, String name) {
        super(name);
        this.account = account;
        this.amount = amount;
    }
    
    @Override
    public void run() {
        account.withdraw(amount, getName());
    }
}

public class BankAccountSimulation {
    public static void main(String[] args) {
        System.out.println("=== Bank Account Synchronization Demo ===\n");
        
        BankAccount account = new BankAccount(10000);
        System.out.println("Initial Balance: $" + account.getBalance());
        System.out.println("\nStarting multiple deposit and withdrawal operations...\n");
        
        DepositThread d1 = new DepositThread(account, 2000, "Deposit-Thread-1");
        DepositThread d2 = new DepositThread(account, 3000, "Deposit-Thread-2");
        WithdrawalThread w1 = new WithdrawalThread(account, 5000, "Withdrawal-Thread-1");
        WithdrawalThread w2 = new WithdrawalThread(account, 4000, "Withdrawal-Thread-2");
        DepositThread d3 = new DepositThread(account, 1500, "Deposit-Thread-3");
        WithdrawalThread w3 = new WithdrawalThread(account, 2500, "Withdrawal-Thread-3");
        
        d1.start();
        w1.start();
        d2.start();
        w2.start();
        d3.start();
        w3.start();
        
        try {
            d1.join();
            d2.join();
            d3.join();
            w1.join();
            w2.join();
            w3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("\nFinal Balance: $" + account.getBalance());
        System.out.println("\n=== All operations completed ===");


        System.out.println("Student: 24CE084 KRISH PATEL");

    }
}
