package utils;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StringUtilsTest {
	@Test
	public void testReverse() {
		assertEquals("dog", StringUtils.reverse("god"));
	}
	@Test
	public void testIsPalindrome() {
		assertTrue(StringUtils.isPalindrome("madam"));
		assertFalse(StringUtils.isPalindrome("never"));
	}
	@Test
	public void testToUpperCase() {
		assertEquals("HELLO", StringUtils.toUpperCase("hello"));
	}
}
