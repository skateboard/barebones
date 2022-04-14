package me.brennan.barebone.task.manager;

import me.brennan.barebone.manager.AbstractMapManager;
import me.brennan.barebone.task.AbstractTask;
import me.brennan.barebone.task.Task;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Brennan / skateboard
 * @since 4/14/2022
 **/
public class TaskManager extends AbstractMapManager<UUID, Task> {
    private final ExecutorService executorService = Executors.newWorkStealingPool();

    public void add(Task task) {
        super.add(task.getUUID(), task);
    }

    public void executeTask(UUID uuid) {
        Task task = get(uuid);
        if (task != null) {
            executeTask(task);
        }
    }

    public void executeTask(Task task) {
        executorService.execute(((AbstractTask) task)::runTask);
    }

    public void stop(UUID uuid) {
        Task task = get(uuid);
        if (task != null) {
            task.stop();
        }
    }
}
