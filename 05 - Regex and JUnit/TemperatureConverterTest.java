package utils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TemperatureConverterTest {

    @Test
    public void testCelsiusToFahrenheit() {
        TemperatureConverter converter = new TemperatureConverter();
        assertEquals(32.0, converter.celsiusToFahrenheit(0), 0.001);
        assertEquals(212.0, converter.celsiusToFahrenheit(100), 0.001);
    }

    @Test
    public void testFahrenheitToCelsius() {
        TemperatureConverter converter = new TemperatureConverter();
        assertEquals(0.0, converter.fahrenheitToCelsius(32), 0.001);
        assertEquals(100.0, converter.fahrenheitToCelsius(212), 0.001);
    }

    @Test
    public void testNegativeTemperature() {
        TemperatureConverter converter = new TemperatureConverter();
        assertEquals(-40.0, converter.celsiusToFahrenheit(-40), 0.001);
        assertEquals(-40.0, converter.fahrenheitToCelsius(-40), 0.001);
    }
}
