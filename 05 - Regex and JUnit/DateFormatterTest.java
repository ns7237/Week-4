package utils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DateFormatterTest {

    @Test
    public void testValidDate() {
        DateFormatter formatter = new DateFormatter();
        assertEquals("2021-12-25", formatter.formatDate("2021-12-25"));
    }

    @Test
    public void testInvalidDateFormat() {
        DateFormatter formatter = new DateFormatter();
        assertNull(formatter.formatDate("12-25-2021")); 
    }

    @Test
    public void testInvalidDateValue() {
        DateFormatter formatter = new DateFormatter();
        assertNull(formatter.formatDate("2021-13-25"));
        assertNull(formatter.formatDate("2021-02-30")); 
    }

    @Test
    public void testEmptyString() {
        DateFormatter formatter = new DateFormatter();
        assertNull(formatter.formatDate("")); 
    }

    @Test
    public void testNullInput() {
        DateFormatter formatter = new DateFormatter();
        assertNull(formatter.formatDate(null)); 
    }
}
