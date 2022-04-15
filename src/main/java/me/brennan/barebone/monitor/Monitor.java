package me.brennan.barebone.monitor;

import me.brennan.barebone.state.State;
import me.brennan.barebone.task.Task;
import me.brennan.barebone.task.types.MonitoredTask;

import java.util.List;
import java.util.UUID;

/**
 * @author Brennan / skateboard
 * @since 4/14/2022
 **/
public interface Monitor {

    UUID getUUID();

    List<MonitoredTask> getTasks();

    State stop();

    boolean isStopped();

    void setStopped(boolean stopped);

    State next(State state);
}
