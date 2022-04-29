import me.brennan.barebones.task.manager.TaskManager;
import org.junit.jupiter.api.Test;

/**
 * @author Brennan / skateboard
 * @since 4/14/2022
 **/
public class TaskTest {

    @Test
    public void testTask() {
        final TestEngine engine = new TestEngine();
        engine.start();

        engine.getTaskManager().executeTask(new TestTask());

//        final TestMonitor monitor = new TestMonitor();
//        final TestMonitorTask task = new TestMonitorTask();
//
//        monitor.addTask(task);
//
//        engine.getVertx().deployVerticle(task);
//        engine.getVertx().deployVerticle(monitor);

        while (true);
    }
}
