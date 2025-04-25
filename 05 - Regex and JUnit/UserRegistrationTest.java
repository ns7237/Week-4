package utils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserRegistrationTest {

    @Test
    public void testValidUserRegistration() {
        UserRegistration registration = new UserRegistration();
        assertDoesNotThrow(() -> registration.registerUser("validUser", "user@example.com", "validPassword123"));
    }

    @Test
    public void testInvalidUsername() {
        UserRegistration registration = new UserRegistration();
        assertThrows(IllegalArgumentException.class, () -> registration.registerUser("", "user@example.com", "validPassword123"));
        assertThrows(IllegalArgumentException.class, () -> registration.registerUser(null, "user@example.com", "validPassword123"));
    }

    @Test
    public void testInvalidEmail() {
        UserRegistration registration = new UserRegistration();
        assertThrows(IllegalArgumentException.class, () -> registration.registerUser("validUser", "invalidEmail", "validPassword123"));
        assertThrows(IllegalArgumentException.class, () -> registration.registerUser("validUser", null, "validPassword123"));
    }

    @Test
    public void testInvalidPassword() {
        UserRegistration registration = new UserRegistration();
        assertThrows(IllegalArgumentException.class, () -> registration.registerUser("validUser", "user@example.com", "short"));
        assertThrows(IllegalArgumentException.class, () -> registration.registerUser("validUser", "user@example.com", null));
    }
}
