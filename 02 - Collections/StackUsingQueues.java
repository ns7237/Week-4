import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public StackUsingQueues() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    // Push element to stack
    public void push(int x) {
        queue1.add(x);
    }

    // Pop element from stack
    public int pop() {
        if (queue1.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        // Move all elements except the last one from queue1 to queue2
        while (queue1.size() > 1) {
            queue2.add(queue1.poll());
        }

        // The last element in queue1 is the top of the stack
        int top = queue1.poll();

        // Swap the queues
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return top;
    }

    // Get the top element of the stack
    public int top() {
        if (queue1.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        // Move all elements except the last one from queue1 to queue2
        while (queue1.size() > 1) {
            queue2.add(queue1.poll());
        }

        // The last element in queue1 is the top of the stack
        int top = queue1.peek();

        // Add the element back to queue1
        queue2.add(queue1.poll());

        // Swap the queues
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return top;
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Top element: " + stack.top()); // Output: 3
        System.out.println("Pop element: " + stack.pop()); // Output: 3
        System.out.println("Top element after pop: " + stack.top()); // Output: 2
    }
}
