import me.brennan.barebones.task.manager.TaskManager;
import org.junit.jupiter.api.Test;

/**
 * @author Brennan / skateboard
 * @since 4/14/2022
 **/
public class TaskTest {

    @Test
    public void testTask() {
        final TaskManager taskManager = new TaskManager();

        final TestMonitor monitor = new TestMonitor();
        final TestMonitorTask task = new TestMonitorTask();

        taskManager.add(task);

        monitor.addTask(task);

        new Thread(monitor::runMonitor).start();
        taskManager.executeTask(task.getUUID());

        // keep main thread running
        while (true) {

        }
    }
}
