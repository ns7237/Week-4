import java.io.*;

public class UserInputToFile {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileWriter fileWriter = null;

        try {
            System.out.print("Enter your name: ");
            String name = reader.readLine();

            System.out.print("Enter your age: ");
            String age = reader.readLine();

            System.out.print("Enter your favorite programming language: ");
            String language = reader.readLine();

            fileWriter = new FileWriter("user_data.txt", true);

            fileWriter.write("Name: " + name + "\n");
            fileWriter.write("Age: " + age + "\n");
            fileWriter.write("Favorite Programming Language: " + language + "\n");
            fileWriter.write("\n");

            System.out.println("Data saved to user_data.txt!");

        } catch (IOException e) {
            System.out.println("An error occurred while reading input or writing to the file: " + e.getMessage());
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException e) {
                System.out.println("Error while closing resources: " + e.getMessage());
            }
        }
    }
}
