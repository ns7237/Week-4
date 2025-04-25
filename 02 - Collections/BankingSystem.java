import java.util.*;

public class BankingSystem {

    private Map<String, Double> customerAccounts = new HashMap<>();
    private Map<String, Double> sortedByBalance = new TreeMap<>(Comparator.comparingDouble(customerAccounts::get));
    private Queue<String> withdrawalRequests = new LinkedList<>();

    public void addCustomer(String accountNumber, double balance) {
        customerAccounts.put(accountNumber, balance);
        sortedByBalance.put(accountNumber, balance);
    }

    public void withdraw(String accountNumber, double amount) {
        double currentBalance = customerAccounts.getOrDefault(accountNumber, -1.0);
        if (currentBalance == -1.0) {
            System.out.println("Account does not exist!");
        } else if (currentBalance < amount) {
            System.out.println("Insufficient balance in account: " + accountNumber);
        } else {
            customerAccounts.put(accountNumber, currentBalance - amount);
            sortedByBalance.put(accountNumber, currentBalance - amount);
            System.out.println("Successfully withdrew $" + amount + " from account: " + accountNumber);
        }
    }

    public void addWithdrawalRequest(String accountNumber) {
        withdrawalRequests.add(accountNumber);
    }

    public void processWithdrawals() {
        while (!withdrawalRequests.isEmpty()) {
            String accountNumber = withdrawalRequests.poll();
            double withdrawalAmount = 100.0;
            withdraw(accountNumber, withdrawalAmount);
        }
    }

    public void displayCustomerAccounts() {
        System.out.println("\nCustomer Accounts:");
        for (Map.Entry<String, Double> entry : customerAccounts.entrySet()) {
            System.out.println("Account Number: " + entry.getKey() + ", Balance: $" + entry.getValue());
        }
    }

    public void displaySortedByBalance() {
        System.out.println("\nCustomers Sorted by Balance:");
        for (Map.Entry<String, Double> entry : sortedByBalance.entrySet()) {
            System.out.println("Account Number: " + entry.getKey() + ", Balance: $" + entry.getValue());
        }
    }

    public static void main(String[] args) {
        BankingSystem bankingSystem = new BankingSystem();

        bankingSystem.addCustomer("A123", 500.00);
        bankingSystem.addCustomer("B456", 1000.00);
        bankingSystem.addCustomer("C789", 1500.00);

        bankingSystem.displayCustomerAccounts();

        bankingSystem.addWithdrawalRequest("A123");
        bankingSystem.addWithdrawalRequest("B456");

        bankingSystem.processWithdrawals();

        bankingSystem.displayCustomerAccounts();

        bankingSystem.displaySortedByBalance();
    }
}
