package q;

import java.util.*;
import java.util.stream.Collectors;

class Claim {
    int claimId;
    String policyNumber;
    double claimAmount;
    String claimDate;
    String status;

    Claim(int claimId, String policyNumber, double claimAmount, String claimDate, String status) {
        this.claimId = claimId;
        this.policyNumber = policyNumber;
        this.claimAmount = claimAmount;
        this.claimDate = claimDate;
        this.status = status;
    }
}

class PolicyClaimStats {
    double totalClaimAmount;
    double averageClaimAmount;

    PolicyClaimStats(double totalClaimAmount, double averageClaimAmount) {
        this.totalClaimAmount = totalClaimAmount;
        this.averageClaimAmount = averageClaimAmount;
    }

    @Override
    public String toString() {
        return "Total: " + totalClaimAmount + ", Average: " + averageClaimAmount;
    }
}

public class P4 {
    public static void main(String[] args) {
        List<Claim> claims = Arrays.asList(
            new Claim(1, "P123", 6000, "2023-01-15", "Approved"),
            new Claim(2, "P124", 3000, "2023-02-20", "Rejected"),
            new Claim(3, "P123", 7000, "2023-03-10", "Approved"),
            new Claim(4, "P125", 8000, "2023-04-05", "Approved"),
            new Claim(5, "P123", 5000, "2023-05-15", "Approved")
        );

        Map<String, List<Claim>> groupedClaims = claims.stream()
            .filter(c -> c.status.equals("Approved") && c.claimAmount > 5000)
            .collect(Collectors.groupingBy(c -> c.policyNumber));

        Map<String, PolicyClaimStats> policyStats = groupedClaims.entrySet().stream()
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                entry -> {
                    double total = entry.getValue().stream().mapToDouble(c -> c.claimAmount).sum();
                    double average = entry.getValue().stream().mapToDouble(c -> c.claimAmount).average().orElse(0);
                    return new PolicyClaimStats(total, average);
                }
            ));

        policyStats.entrySet().stream()
            .sorted((e1, e2) -> Double.compare(e2.getValue().totalClaimAmount, e1.getValue().totalClaimAmount))
            .limit(3)
            .forEach(e -> System.out.println("Policy: " + e.getKey() + " " + e.getValue()));
    }
}
