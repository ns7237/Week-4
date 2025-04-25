import java.util.*;
import java.text.*;
import java.time.*;
import java.time.temporal.ChronoUnit;

class Policy {
    private String policyNumber;
    private String policyholderName;
    private LocalDate expiryDate;
    private String coverageType;
    private double premiumAmount;

    public Policy(String policyNumber, String policyholderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public String getPolicyholderName() {
        return policyholderName;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public String getCoverageType() {
        return coverageType;
    }

    public double getPremiumAmount() {
        return premiumAmount;
    }

    @Override
    public String toString() {
        return "Policy Number: " + policyNumber + ", Policyholder: " + policyholderName + ", Expiry Date: " + expiryDate + ", Coverage: " + coverageType + ", Premium: " + premiumAmount;
    }

    @Override
    public int hashCode() {
        return policyNumber.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Policy policy = (Policy) obj;
        return policyNumber.equals(policy.policyNumber);
    }
}

public class InsurancePolicyManagement {

    private Set<Policy> hashSet = new HashSet<>();
    private Set<Policy> linkedHashSet = new LinkedHashSet<>();
    private Set<Policy> treeSet = new TreeSet<>(Comparator.comparing(Policy::getExpiryDate));

    public void addPolicyToHashSet(Policy policy) {
        hashSet.add(policy);
    }

    public void addPolicyToLinkedHashSet(Policy policy) {
        linkedHashSet.add(policy);
    }

    public void addPolicyToTreeSet(Policy policy) {
        treeSet.add(policy);
    }

    public void displayAllPolicies(Set<Policy> set) {
        for (Policy policy : set) {
            System.out.println(policy);
        }
    }

    public void displayPoliciesExpiringSoon(Set<Policy> set) {
        LocalDate currentDate = LocalDate.now();
        LocalDate soonExpiryDate = currentDate.plus(30, ChronoUnit.DAYS);

        for (Policy policy : set) {
            if (!policy.getExpiryDate().isBefore(currentDate) && policy.getExpiryDate().isBefore(soonExpiryDate)) {
                System.out.println(policy);
            }
        }
    }

    public void displayPoliciesByCoverageType(Set<Policy> set, String coverageType) {
        for (Policy policy : set) {
            if (policy.getCoverageType().equalsIgnoreCase(coverageType)) {
                System.out.println(policy);
            }
        }
    }

    public void displayDuplicatePolicies() {
        Set<String> policyNumbers = new HashSet<>();
        for (Policy policy : hashSet) {
            if (!policyNumbers.add(policy.getPolicyNumber())) {
                System.out.println("Duplicate Policy: " + policy);
            }
        }
    }

    public void performanceComparison() {
        long startTime, endTime;

        // HashSet Performance
        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            hashSet.add(new Policy("Policy" + i, "Name" + i, LocalDate.now().plusDays(i), "Health", 1000.0));
        }
        endTime = System.nanoTime();
        System.out.println("HashSet Add Time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        hashSet.contains("Policy50000");
        endTime = System.nanoTime();
        System.out.println("HashSet Search Time: " + (endTime - startTime) + " ns");

        // LinkedHashSet Performance
        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            linkedHashSet.add(new Policy("Policy" + i, "Name" + i, LocalDate.now().plusDays(i), "Auto", 2000.0));
        }
        endTime = System.nanoTime();
        System.out.println("LinkedHashSet Add Time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        linkedHashSet.contains("Policy50000");
        endTime = System.nanoTime();
        System.out.println("LinkedHashSet Search Time: " + (endTime - startTime) + " ns");

        // TreeSet Performance
        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            treeSet.add(new Policy("Policy" + i, "Name" + i, LocalDate.now().plusDays(i), "Home", 1500.0));
        }
        endTime = System.nanoTime();
        System.out.println("TreeSet Add Time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        treeSet.contains("Policy50000");
        endTime = System.nanoTime();
        System.out.println("TreeSet Search Time: " + (endTime - startTime) + " ns");
    }

    public static void main(String[] args) {
        InsurancePolicyManagement policyManager = new InsurancePolicyManagement();

        // Create some policy instances
        Policy policy1 = new Policy("P001", "Alice", LocalDate.of(2023, 6, 30), "Health", 500.0);
        Policy policy2 = new Policy("P002", "Bob", LocalDate.of(2023, 5, 15), "Auto", 300.0);
        Policy policy3 = new Policy("P003", "Carol", LocalDate.of(2023, 6, 5), "Health", 600.0);
        Policy policy4 = new Policy("P004", "David", LocalDate.of(2023, 6, 20), "Home", 700.0);

        // Add policies to sets
        policyManager.addPolicyToHashSet(policy1);
        policyManager.addPolicyToLinkedHashSet(policy2);
        policyManager.addPolicyToTreeSet(policy3);
        policyManager.addPolicyToTreeSet(policy4);

        // Display all policies
        System.out.println("All Policies:");
        policyManager.displayAllPolicies(policyManager.hashSet);
        policyManager.displayAllPolicies(policyManager.linkedHashSet);
        policyManager.displayAllPolicies(policyManager.treeSet);

        // Display policies expiring soon
        System.out.println("\nPolicies Expiring Soon:");
        policyManager.displayPoliciesExpiringSoon(policyManager.hashSet);
        policyManager.displayPoliciesExpiringSoon(policyManager.treeSet);

        // Display policies with a specific coverage type
        System.out.println("\nHealth Policies:");
        policyManager.displayPoliciesByCoverageType(policyManager.hashSet, "Health");

        // Check for duplicate policies
        System.out.println("\nDuplicate Policies:");
        policyManager.displayDuplicatePolicies();

        // Perform performance comparison
        System.out.println("\nPerformance Comparison:");
        policyManager.performanceComparison();
    }
}
