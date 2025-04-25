package utils;

public class TaskRunner {
    public String longRunningTask() {
        try {
            Thread.sleep(1000); 
        } catch (InterruptedException e) {
            return "Interrupted";
        }
        return "Completed";
    }
}
