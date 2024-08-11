class BankAccount {
    protected double balance;

    public BankAccount() {
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. Current balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. Current balance: " + balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds.");
        }
    }

    public double getBalance() {
        return balance;
    }
}

class DepositAccount extends BankAccount {
    private long lastDepositTimestamp;

    public DepositAccount() {
        super();
        this.lastDepositTimestamp = System.currentTimeMillis();
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount);
        lastDepositTimestamp = System.currentTimeMillis();
    }

    @Override
    public void withdraw(double amount) {
        long currentTime = System.currentTimeMillis();
        long monthInMillis = 30 * 24 * 60 * 60 * 1000L;

        if (currentTime - lastDepositTimestamp >= monthInMillis) {
            super.withdraw(amount);
        } else {
            System.out.println("Cannot withdraw from deposit account within a month of the last deposit.");
        }
    }
}

class CardAccount extends BankAccount {
    private static final double COMMISSION_RATE = 0.01;

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            double commission = amount * COMMISSION_RATE;
            balance -= (amount + commission);
            System.out.println("Withdrawal successful. Commission applied: " + commission);
            System.out.println("Current balance: " + balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds.");
        }
    }
}

public class Banking {
    public static void main(String[] args) {
        BankAccount basicAccount = new BankAccount();
        basicAccount.deposit(1000);
        basicAccount.withdraw(500);
        System.out.println("Basic Account Balance: " + basicAccount.getBalance());

        DepositAccount depositAccount = new DepositAccount();
        depositAccount.deposit(2000);
        depositAccount.withdraw(1000);
        System.out.println("Deposit Account Balance: " + depositAccount.getBalance());

        CardAccount cardAccount = new CardAccount();
        cardAccount.deposit(3000);
        cardAccount.withdraw(1500);
        System.out.println("Card Account Balance: " + cardAccount.getBalance());
    }
}
