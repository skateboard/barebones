import me.brennan.barebones.Barebone;
import me.brennan.barebones.task.manager.TaskManager;

/**
 * @author Brennan / skateboard
 * @since 4/29/2022
 **/
public class TestEngine extends Barebone {
    private final TaskManager taskManager;

    public TestEngine() {
        this.taskManager = new TaskManager();
    }

    @Override
    public void start() {
        this.add(this.taskManager);
        this.deploy();
    }

    public TaskManager getTaskManager() {
        return taskManager;
    }
}
