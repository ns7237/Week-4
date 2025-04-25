package utils;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

public class NumberUtilsTest {

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6})
    public void testIsEvenWithEvenNumbers(int number) {
        assertTrue(NumberUtils.isEven(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {7, 9})
    public void testIsEvenWithOddNumbers(int number) {
        assertFalse(NumberUtils.isEven(number));
    }
}
