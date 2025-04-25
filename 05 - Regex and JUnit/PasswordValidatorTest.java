package utils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PasswordValidatorTest {

    @Test
    public void testValidPassword() {
        PasswordValidator validator = new PasswordValidator();
        assertTrue(validator.isValid("Secure123"));
    }

    @Test
    public void testPasswordTooShort() {
        PasswordValidator validator = new PasswordValidator();
        assertFalse(validator.isValid("Ab1"));
    }

    @Test
    public void testPasswordMissingUppercase() {
        PasswordValidator validator = new PasswordValidator();
        assertFalse(validator.isValid("secure123"));
    }

    @Test
    public void testPasswordMissingDigit() {
        PasswordValidator validator = new PasswordValidator();
        assertFalse(validator.isValid("SecurePwd"));
    }

    @Test
    public void testNullPassword() {
        PasswordValidator validator = new PasswordValidator();
        assertFalse(validator.isValid(null));
    }
}
