package q;

import java.util.*;
import java.util.stream.Collectors;

class Transaction {
    int transactionId;
    String policyNumber;
    double amount;
    String transactionDate;
    boolean isFraudulent;

    Transaction(int transactionId, String policyNumber, double amount, String transactionDate, boolean isFraudulent) {
        this.transactionId = transactionId;
        this.policyNumber = policyNumber;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.isFraudulent = isFraudulent;
    }
}

class FraudulentTransactionStats {
    int fraudCount;
    double totalFraudAmount;

    FraudulentTransactionStats(int fraudCount, double totalFraudAmount) {
        this.fraudCount = fraudCount;
        this.totalFraudAmount = totalFraudAmount;
    }

    @Override
    public String toString() {
        return "Fraud Count: " + fraudCount + ", Total Fraud Amount: " + totalFraudAmount;
    }
}

public class P6 {
    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
            new Transaction(1, "P123", 12000, "2023-01-10", true),
            new Transaction(2, "P124", 5000, "2023-02-15", true),
            new Transaction(3, "P123", 15000, "2023-03-20", true),
            new Transaction(4, "P125", 8000, "2023-04-05", false),
            new Transaction(5, "P123", 25000, "2023-05-25", true),
            new Transaction(6, "P123", 12000, "2023-06-30", true)
        );

        Map<String, FraudulentTransactionStats> policyFraudStats = transactions.stream()
            .filter(t -> t.isFraudulent && t.amount > 10000)
            .collect(Collectors.groupingBy(
                t -> t.policyNumber,
                Collectors.collectingAndThen(
                    Collectors.toList(),
                    list -> {
                        int count = list.size();
                        double totalAmount = list.stream().mapToDouble(t -> t.amount).sum();
                        return new FraudulentTransactionStats(count, totalAmount);
                    }
                )
            ));

        policyFraudStats.forEach((policy, stats) -> {
            if (stats.fraudCount > 5 || stats.totalFraudAmount > 50000) {
                System.out.println("ALERT: Policy " + policy + " has high fraudulent activity. " + stats);
            }
        });
    }
}
