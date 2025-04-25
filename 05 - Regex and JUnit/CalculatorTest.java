package calculator;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
	Calculator calc = new Calculator();
	
	@Test
	public void testAdd() {
		assertEquals(5,calc.add(2, 3));
	}
    @Test
    public void testSubtract() {
        assertEquals(1, calc.sub(3, 2));
    }

    @Test
    public void testMultiply() {
        assertEquals(6, calc.mul(2, 3));
    }

    @Test
    public void testDivide() {
        assertEquals(2.0, calc.div(6, 3), 0.001);
    }

    @Test
    public void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> calc.div(5, 0));
    }
}
