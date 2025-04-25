import java.io.*;

public class CheckedExceptionExample {

    public static void main(String[] args) {
        File file = new File("data.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }
}
