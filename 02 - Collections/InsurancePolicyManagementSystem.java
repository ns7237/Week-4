import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class InsurancePolicyManagementSystem {

    static class Policy {
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
    }

    private Map<String, Policy> hashMap = new HashMap<>();
    private Map<String, Policy> linkedHashMap = new LinkedHashMap<>();
    private Map<String, Policy> treeMap = new TreeMap<>();

    public void addPolicyToHashMap(Policy policy) {
        hashMap.put(policy.getPolicyNumber(), policy);
    }

    public void addPolicyToLinkedHashMap(Policy policy) {
        linkedHashMap.put(policy.getPolicyNumber(), policy);
    }

    public void addPolicyToTreeMap(Policy policy) {
        treeMap.put(policy.getPolicyNumber(), policy);
    }

    public Policy retrievePolicyByNumber(String policyNumber) {
        return hashMap.get(policyNumber);
    }

    public void listPoliciesExpiringSoon() {
        LocalDate currentDate = LocalDate.now();
        LocalDate soonExpiryDate = currentDate.plus(30, ChronoUnit.DAYS);

        System.out.println("Policies Expiring Within the Next 30 Days:");
        for (Policy policy : treeMap.values()) {
            if (!policy.getExpiryDate().isBefore(currentDate) && policy.getExpiryDate().isBefore(soonExpiryDate)) {
                System.out.println(policy);
            }
        }
    }

    public void listPoliciesByPolicyholder(String policyholderName) {
        System.out.println("Policies for Policyholder: " + policyholderName);
        for (Policy policy : hashMap.values()) {
            if (policy.getPolicyholderName().equalsIgnoreCase(policyholderName)) {
                System.out.println(policy);
            }
        }
    }

    public void removeExpiredPolicies() {
        LocalDate currentDate = LocalDate.now();
        System.out.println("Removing Expired Policies:");
        Iterator<Map.Entry<String, Policy>> iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Policy> entry = iterator.next();
            if (entry.getValue().getExpiryDate().isBefore(currentDate)) {
                System.out.println("Removed: " + entry.getValue());
                iterator.remove();
            }
        }
    }

    public void displayPolicies(Map<String, Policy> map) {
        for (Policy policy : map.values()) {
            System.out.println(policy);
        }
    }

    public static void main(String[] args) {
        InsurancePolicyManagementSystem system = new InsurancePolicyManagementSystem();

        Policy policy1 = new Policy("P001", "Alice", LocalDate.of(2023, 6, 30), "Health", 500.0);
        Policy policy2 = new Policy("P002", "Bob", LocalDate.of(2023, 5, 15), "Auto", 300.0);
        Policy policy3 = new Policy("P003", "Carol", LocalDate.of(2023, 6, 5), "Health", 600.0);
        Policy policy4 = new Policy("P004", "David", LocalDate.of(2023, 6, 20), "Home", 700.0);
        Policy policy5 = new Policy("P005", "Alice", LocalDate.of(2023, 7, 1), "Auto", 400.0);

        system.addPolicyToHashMap(policy1);
        system.addPolicyToLinkedHashMap(policy2);
        system.addPolicyToTreeMap(policy3);
        system.addPolicyToTreeMap(policy4);
        system.addPolicyToHashMap(policy5);

        System.out.println("Retrieve Policy with Number P002: " + system.retrievePolicyByNumber("P002"));

        system.listPoliciesExpiringSoon();

        system.listPoliciesByPolicyholder("Alice");

        system.removeExpiredPolicies();

        System.out.println("\nPolicies in HashMap:");
        system.displayPolicies(system.hashMap);
        System.out.println("\nPolicies in LinkedHashMap:");
        system.displayPolicies(system.linkedHashMap);
        System.out.println("\nPolicies in TreeMap:");
        system.displayPolicies(system.treeMap);
    }
}
