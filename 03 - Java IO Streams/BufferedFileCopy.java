import java.io.*;
import java.nio.file.*;

public class BufferedFileCopy {

    public static void main(String[] args) {
        String sourceFile = "largeSourceFile.txt";
        String destinationFileBuffered = "destinationBuffered.txt";
        String destinationFileUnbuffered = "destinationUnbuffered.txt";

        // Measure performance of buffered file copy
        long startTimeBuffered = System.nanoTime();
        copyFileWithBufferedStreams(sourceFile, destinationFileBuffered);
        long endTimeBuffered = System.nanoTime();
        long durationBuffered = endTimeBuffered - startTimeBuffered;

        // Measure performance of unbuffered file copy
        long startTimeUnbuffered = System.nanoTime();
        copyFileWithUnbufferedStreams(sourceFile, destinationFileUnbuffered);
        long endTimeUnbuffered = System.nanoTime();
        long durationUnbuffered = endTimeUnbuffered - startTimeUnbuffered;

        // Output execution times
        System.out.println("Buffered file copy time (in nanoseconds): " + durationBuffered);
        System.out.println("Unbuffered file copy time (in nanoseconds): " + durationUnbuffered);
    }

    // Method to copy file using BufferedInputStream and BufferedOutputStream
    private static void copyFileWithBufferedStreams(String sourceFile, String destinationFile) {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFile));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destinationFile))) {

            byte[] buffer = new byte[4096]; // 4 KB buffer
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            System.out.println("Error during buffered file copy: " + e.getMessage());
        }
    }

    // Method to copy file using FileInputStream and FileOutputStream (unbuffered)
    private static void copyFileWithUnbufferedStreams(String sourceFile, String destinationFile) {
        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destinationFile)) {

            int byteRead;
            while ((byteRead = fis.read()) != -1) {
                fos.write(byteRead);
            }
        } catch (IOException e) {
            System.out.println("Error during unbuffered file copy: " + e.getMessage());
        }
    }
}
