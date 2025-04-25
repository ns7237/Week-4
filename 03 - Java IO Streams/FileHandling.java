import java.io.*;

public class FileHandling {

    public static void main(String[] args) {
        String sourceFile = "source.txt";
        String destinationFile = "destination.txt";

        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            File source = new File(sourceFile);
            if (!source.exists()) {
                System.out.println("Source file does not exist.");
                return;
            }

            fis = new FileInputStream(source);
            fos = new FileOutputStream(destinationFile);

            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }

            System.out.println("File copied successfully!");

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            try {
                if (fis != null) fis.close();
                if (fos != null) fos.close();
            } catch (IOException e) {
                System.out.println("Error while closing streams: " + e.getMessage());
            }
        }
    }
}
