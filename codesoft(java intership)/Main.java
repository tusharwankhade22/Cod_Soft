import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            System.out.println("Insufficient funds");
            return false;
        }
    }
}

class ATM {
    private BankAccount userAccount;

    public ATM(BankAccount account) {
        this.userAccount = account;
    }

    public void displayMenu() {
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void performTransaction(int option, double amount) {
        switch (option) {
            case 1:
                System.out.println("Balance: $" + userAccount.getBalance());
                break;
            case 2:
                userAccount.deposit(amount);
                System.out.println("Deposit successful. New balance: $" + userAccount.getBalance());
                break;
            case 3:
                if (userAccount.withdraw(amount)) {
                    System.out.println("Withdrawal successful. New balance: $" + userAccount.getBalance());
                }
                break;
            case 4:
                System.out.println("Exiting ATM. Thank you!");
                break;
            default:
                System.out.println("Invalid option. Please choose a valid option.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter initial balance: $");
        double initialBalance = scanner.nextDouble();

        BankAccount userAccount = new BankAccount(initialBalance);
        ATM atm = new ATM(userAccount);

        int option;
        do {
            atm.displayMenu();
            System.out.print("Enter your choice (1-4): ");
            option = scanner.nextInt();

            if (option == 4) {
                break;
            }

            System.out.print("Enter amount: $");
            double amount = scanner.nextDouble();

            if (amount < 0) {
                System.out.println("Invalid amount. Please enter a positive value.");
                continue;
            }

            atm.performTransaction(option, amount);

        } while (option != 4);

        scanner.close();
    }
}
