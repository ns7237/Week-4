import java.io.*;

public class ImageByteArrayConverter {

    public static void main(String[] args) {
        String inputImagePath = "original.jpg";
        String outputImagePath = "copied.jpg";

        try {
            FileInputStream fis = new FileInputStream(inputImagePath);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }

            byte[] imageBytes = baos.toByteArray();

            ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
            FileOutputStream fos = new FileOutputStream(outputImagePath);

            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            fis.close();
            baos.close();
            bais.close();
            fos.close();

            System.out.println("Image has been copied successfully using byte array.");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
