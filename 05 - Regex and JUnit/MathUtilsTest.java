package utils;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MathUtilsTest {

    @Test
    public void testDivideByNonZero() {
        assertEquals(2, MathUtils.divide(10, 5));
    }

    @Test
    public void testDivideByZeroThrowsException() {
        assertThrows(ArithmeticException.class, () -> MathUtils.divide(10, 0));
    }
}
