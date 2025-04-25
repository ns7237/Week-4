package utils;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.io.IOException;

public class FileProcessorTest {

    @Test
    public void testWriteAndReadFile() throws IOException {
        FileProcessor processor = new FileProcessor();
        String filename = "testfile.txt";
        String content = "Hello File";

        processor.writeToFile(filename, content);
        String result = processor.readFromFile(filename);

        assertEquals(content, result);
    }

    @Test
    public void testFileExistsAfterWrite() throws IOException {
        FileProcessor processor = new FileProcessor();
        String filename = "existfile.txt";
        processor.writeToFile(filename, "Some content");

        File file = new File(filename);
        assertTrue(file.exists());
    }

    @Test
    public void testReadNonExistentFileThrowsException() {
        FileProcessor processor = new FileProcessor();
        assertThrows(IOException.class, () -> processor.readFromFile("no_such_file.txt"));
    }
}
