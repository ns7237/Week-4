package utils;

public class DatabaseConnection {
    private boolean connected;

    public void connect() {
        connected = true;
        System.out.println("Connected to database");
    }

    public void disconnect() {
        connected = false;
        System.out.println("Disconnected from database");
    }

    public boolean isConnected() {
        return connected;
    }
}
