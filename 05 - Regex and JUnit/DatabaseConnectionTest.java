package utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DatabaseConnectionTest {
    private DatabaseConnection db;

    @BeforeEach
    public void setUp() {
        db = new DatabaseConnection();
        db.connect();
    }

    @AfterEach
    public void tearDown() {
        db.disconnect();
    }

    @Test
    public void testConnectionEstablished() {
        assertTrue(db.isConnected());
    }

    @Test
    public void testMultipleConnections() {
        assertTrue(db.isConnected());
        db.disconnect();
        assertFalse(db.isConnected());
        db.connect();
        assertTrue(db.isConnected());
    }
}
