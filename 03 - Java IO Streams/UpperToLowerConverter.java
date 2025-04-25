import java.io.*;

public class UpperToLowerConverter {

    public static void main(String[] args) {
        String inputFile = "user_data.txt";
        String outputFile = "output.txt";

        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), "UTF-8"));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile), "UTF-8"))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.toLowerCase());
                writer.newLine();
            }

            System.out.println("Conversion completed. All uppercase letters converted to lowercase.");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
