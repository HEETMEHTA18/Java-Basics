class BankAccount {
    private int balance = 1000;

    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName() + " deposited " + amount + ". Balance: " + balance);
    }

    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdrew " + amount + ". Balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " insufficient funds. Balance: " + balance);
        }
    }
}

class DepositThread extends Thread {
    BankAccount account;
    DepositThread(BankAccount acc) { this.account = acc; }
    public void run() { account.deposit(500); }
}

class WithdrawThread extends Thread {
    BankAccount account;
    WithdrawThread(BankAccount acc) { this.account = acc; }
    public void run() { account.withdraw(700); }
}

public class BankAccountSync {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount();

        DepositThread t1 = new DepositThread(acc);
        WithdrawThread t2 = new WithdrawThread(acc);
        WithdrawThread t3 = new WithdrawThread(acc);

        t1.start();
        t2.start();
        t3.start();
    }
}
