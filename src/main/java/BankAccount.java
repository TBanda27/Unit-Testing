public class BankAccount {
    private double balance;
    private final double minBalance;
    private final boolean isActive;
    private String accountHolder;

    public BankAccount(double balance, double minBalance){
        if(balance < 0){
            throw new IllegalArgumentException("Balance cannot be negative");
        }
        this.balance = balance;
        if(balance < minBalance){
            throw new IllegalArgumentException("Balance cannot be less than Min Balance");
        }
        this.minBalance = minBalance;
        isActive = true;
    }

    public void deposit(double amount) throws InterruptedException {
        Thread.sleep(10);
        if(amount < 0){
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        this.balance += amount;
    }

    public void withdraw(double amount){
        if(amount < 0){
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        if( balance - amount < minBalance ){
            throw new IllegalArgumentException("Balance cannot be less than Min Balance");
        }
        this.balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
    public boolean isActive() {
        return isActive;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }
    public String getAccountHolder() {
        return accountHolder;
    }
}
