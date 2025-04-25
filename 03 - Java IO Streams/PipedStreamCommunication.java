import java.io.*;

public class PipedStreamCommunication {

    public static void main(String[] args) {
        try {
            PipedOutputStream output = new PipedOutputStream();
            PipedInputStream input = new PipedInputStream(output);

            Thread writerThread = new Thread(new Writer(output));
            Thread readerThread = new Thread(new Reader(input));

            writerThread.start();
            readerThread.start();

        } catch (IOException e) {
            System.out.println("Pipe connection error: " + e.getMessage());
        }
    }

    static class Writer implements Runnable {
        private PipedOutputStream out;

        public Writer(PipedOutputStream out) {
            this.out = out;
        }

        public void run() {
            try {
                String data = "Message from writer thread";
                out.write(data.getBytes());
                out.close();
            } catch (IOException e) {
                System.out.println("Writer error: " + e.getMessage());
            }
        }
    }

    static class Reader implements Runnable {
        private PipedInputStream in;

        public Reader(PipedInputStream in) {
            this.in = in;
        }

        public void run() {
            try {
                int data;
                while ((data = in.read()) != -1) {
                    System.out.print((char) data);
                }
                in.close();
            } catch (IOException e) {
                System.out.println("Reader error: " + e.getMessage());
            }
        }
    }
}
