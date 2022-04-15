package me.brennan.barebone.monitor;

import me.brennan.barebone.state.State;
import me.brennan.barebone.state.States;
import me.brennan.barebone.task.Task;
import me.brennan.barebone.task.types.MonitoredTask;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/**
 * @author Brennan / skateboard
 * @since 4/14/2022
 **/
public abstract class AbstractMonitor implements Monitor {
    private final UUID uuid = UUID.randomUUID();
    private boolean stopped = false;

    private final List<MonitoredTask> tasks = new LinkedList<>();

    public void runMonitor() {
        State state = States.INITIALIZE; // our initial state

        while (!stopped) { // while loop when not stopped
            state = this.next(state);

            if (state == States.ERROR) { // if we have an error break the loop.
                System.out.println("Monitor has encountered a error!");
                break;
            }
        }
    }

    public void addTask(MonitoredTask task) {
        tasks.add(task);
    }

    @Override
    public UUID getUUID() {
        return uuid;
    }

    @Override
    public State stop() {
        setStopped(true);

        return States.NONE;
    }

    @Override
    public boolean isStopped() {
        return stopped;
    }

    @Override
    public void setStopped(boolean stopped) {
        this.stopped = stopped;
    }

    public void notifyTasks() {
        for (MonitoredTask task : tasks) {
            task.notifyTask();
        }
    }

    @Override
    public List<MonitoredTask> getTasks() {
        return tasks;
    }
}
