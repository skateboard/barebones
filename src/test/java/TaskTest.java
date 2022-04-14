import me.brennan.barebone.task.Task;
import me.brennan.barebone.task.manager.TaskManager;
import org.junit.jupiter.api.Test;

/**
 * @author Brennan / skateboard
 * @since 4/14/2022
 **/
public class TaskTest {

    @Test
    public void testTask() {
        final TaskManager taskManager = new TaskManager();
        final TestTask task = new TestTask();
        taskManager.add(task);
        taskManager.executeTask(task.getUUID());

        // keep main thread running
        while (true) {

        }
    }
}
