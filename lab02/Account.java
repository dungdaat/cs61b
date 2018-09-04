/**
 * This class represents a bank account whose current balance is a nonnegative
 * amount in US dollars.
 */
public class Account {

    public int balance;
    public Account parentAccount;

    /** Initialize an account with the given BALANCE. */
    public Account(int balance, Account parenAccount) {
        this.balance = balance;
        this.parent = parentAccount;
    }
    public Account(int balance) {
        this.balance = balance;
        this.parent = null;
    }

    /** Deposits AMOUNT into the current account. */
    public deposit(int amount) {
        if (amount < 0) {
            System.out.println("Cannot deposit negative amount.");
            return false;
        } else {
            balance += amount;
            return true;
        }
    }

    /**
     * Subtract AMOUNT from the account if possible. If subtracting AMOUNT
     * would leave a negative balance, print an error message and leave the
     * balance unchanged.
     */
    public void withdraw(int amount) {
        // TODO
        if (amount < 0 ) {
            System.out.println("Cannot withdraw negative amount.");
        } else if (balance < amount && this.parent == null) {
            System.out.println("Insufficient funds");
        } else if (balance < amount){
            return this.parent.withdraw(amount-balance)
        }
        balance -= amount;
    }

    /**
     * Merge account OTHER into this account by removing all money from OTHER
     * and depositing it into this account.
     */
    public void merge(Account other) {
        // TODO
        this.balance += other.balance;
        other.balance = 0;
    }
}
