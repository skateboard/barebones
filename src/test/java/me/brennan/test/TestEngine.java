package me.brennan.test;

import me.brennan.barebones.BareboneEngine;
import me.brennan.barebones.file.impl.JsonObjectFileSystem;
import me.brennan.barebones.task.manager.TaskManager;
import me.brennan.test.tasks.TestTask;

/**
 * @author Brennan / skateboard
 * @since 4/29/2022
 **/
public class TestEngine extends BareboneEngine {
    private final TaskManager taskManager;

    public TestEngine() {
        this.taskManager = new TaskManager(new JsonObjectFileSystem());
    }

    @Override
    public void start() {
        this.add(this.taskManager);
        this.deploy();

        // #TODO LOADING FROM FILES

        this.taskManager.executeTask(new TestTask());
    }

    public TaskManager getTaskManager() {
        return taskManager;
    }
}
