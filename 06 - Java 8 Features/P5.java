package q;

import java.util.*;
import java.util.stream.Collectors;

class PolicyHolder {
    int holderId;
    String name;
    int age;
    String policyType;
    double premiumAmount;

    PolicyHolder(int holderId, String name, int age, String policyType, double premiumAmount) {
        this.holderId = holderId;
        this.name = name;
        this.age = age;
        this.policyType = policyType;
        this.premiumAmount = premiumAmount;
    }
}

class RiskAssessment {
    int holderId;
    String name;
    double riskScore;

    RiskAssessment(int holderId, String name, double riskScore) {
        this.holderId = holderId;
        this.name = name;
        this.riskScore = riskScore;
    }

    @Override
    public String toString() {
        return "HolderId: " + holderId + ", Name: " + name + ", Risk Score: " + riskScore;
    }
}

public class P5 {
    public static void main(String[] args) {
        List<PolicyHolder> policyHolders = Arrays.asList(
            new PolicyHolder(1, "Alice", 65, "Life", 2000),
            new PolicyHolder(2, "Bob", 45, "Health", 1500),
            new PolicyHolder(3, "Charlie", 70, "Life", 3000),
            new PolicyHolder(4, "David", 55, "Life", 2500),
            new PolicyHolder(5, "Eve", 62, "Life", 1800)
        );

        List<RiskAssessment> riskAssessments = policyHolders.stream()
            .filter(p -> p.policyType.equals("Life") && p.age > 60)
            .map(p -> new RiskAssessment(p.holderId, p.name, p.premiumAmount / p.age))
            .sorted((r1, r2) -> Double.compare(r2.riskScore, r1.riskScore))
            .collect(Collectors.toList());

        Map<String, List<RiskAssessment>> categorizedRisk = riskAssessments.stream()
            .collect(Collectors.groupingBy(r -> r.riskScore > 0.5 ? "High Risk" : "Low Risk"));

        categorizedRisk.forEach((category, assessments) -> {
            System.out.println(category + ": ");
            assessments.forEach(System.out::println);
        });
    }
}
