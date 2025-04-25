public class CircularBuffer {
    private int[] buffer;
    private int size;
    private int head;
    private int tail;
    private boolean isFull;

    public CircularBuffer(int capacity) {
        buffer = new int[capacity];
        size = capacity;
        head = 0;
        tail = 0;
        isFull = false;
    }

    public void insert(int value) {
        if (isFull) {
            head = (head + 1) % size;
        }

        buffer[tail] = value;
        tail = (tail + 1) % size;

        if (tail == head) {
            isFull = true;
        }
    }

    public void display() {
        if (head == tail && !isFull) {
            System.out.println("Buffer is empty.");
            return;
        }

        int current = head;
        while (current != tail || isFull) {
            System.out.print(buffer[current] + " ");
            current = (current + 1) % size;
            if (!isFull && current == tail) break;
        }
        System.out.println();
    }

    public int size() {
        if (isFull) {
            return size;
        } else if (tail >= head) {
            return tail - head;
        } else {
            return size - head + tail;
        }
    }

    public static void main(String[] args) {
        CircularBuffer buffer = new CircularBuffer(3);

        buffer.insert(1);
        buffer.insert(2);
        buffer.insert(3);
        System.out.print("Buffer after insertions: ");
        buffer.display();

        buffer.insert(4);
        System.out.print("Buffer after inserting 4: ");
        buffer.display();
    }
}
