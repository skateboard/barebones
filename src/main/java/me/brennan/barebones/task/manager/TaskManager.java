package me.brennan.barebones.task.manager;

import me.brennan.barebones.file.FileSystem;
import me.brennan.barebones.manager.impl.AbstractContextMapManager;
import me.brennan.barebones.task.types.AbstractTask;
import me.brennan.barebones.task.Task;

import java.util.UUID;

/**
 * @author Brennan / skateboard
 * @since 4/14/2022
 **/
public class TaskManager extends AbstractContextMapManager<UUID, Task> {
    private final FileSystem<?> fileSystem;

    public TaskManager(FileSystem<?> fileSystem) {
        this.fileSystem = fileSystem;
        this.fileSystem.setVertx(getContext());
    }

    public void add(Task task) {
        super.add(task.getUUID(), task);
    }

    public void executeTask(UUID uuid) {
        AbstractTask task = (AbstractTask) get(uuid);
        if (task != null)
            executeTask(task);
    }

    public void executeTask(AbstractTask task) {
        getContext().deployVerticle(task);
    }

    public void stop(UUID uuid) {
        Task task = get(uuid);
        if (task != null) {
            task.stop();
        }
    }
}
