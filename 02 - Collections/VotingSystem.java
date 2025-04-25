import java.util.*;

public class VotingSystem {

    private Map<String, Integer> votes = new HashMap<>();

    private Map<String, Integer> votesInOrder = new LinkedHashMap<>();

    private Map<String, Integer> sortedVotes = new TreeMap<>();

    public void castVote(String candidate) {
        votes.put(candidate, votes.getOrDefault(candidate, 0) + 1);
        votesInOrder.put(candidate, votesInOrder.getOrDefault(candidate, 0) + 1);
        sortedVotes.put(candidate, votes.get(candidate));
    }

    // Method to display the results in insertion order (LinkedHashMap)
    public void displayVotesInOrder() {
        System.out.println("Votes in Insertion Order:");
        for (Map.Entry<String, Integer> entry : votesInOrder.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }
    }

    public void displayVotesInSortedOrder() {
        System.out.println("\nVotes in Sorted Order:");
        for (Map.Entry<String, Integer> entry : sortedVotes.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }
    }
    public void displayRawVotes() {
        System.out.println("\nRaw Votes (HashMap):");
        for (Map.Entry<String, Integer> entry : votes.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }
    }

    public static void main(String[] args) {
        VotingSystem votingSystem = new VotingSystem();
        votingSystem.castVote("Alice");
        votingSystem.castVote("Bob");
        votingSystem.castVote("Alice");
        votingSystem.castVote("Charlie");
        votingSystem.castVote("Alice");
        votingSystem.castVote("Bob");

        votingSystem.displayVotesInOrder();
        votingSystem.displayVotesInSortedOrder();
        votingSystem.displayRawVotes();
    }
}
