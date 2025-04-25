package utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

public class TaskRunnerTest {

    @Test
    @Timeout(2)
    public void testLongRunningTaskTimeout() {
        TaskRunner taskRunner = new TaskRunner();
        taskRunner.longRunningTask();
    }
}
