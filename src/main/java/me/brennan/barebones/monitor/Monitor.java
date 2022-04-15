package me.brennan.barebones.monitor;

import me.brennan.barebones.state.State;
import me.brennan.barebones.task.types.MonitoredTask;
import okhttp3.OkHttpClient;

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

    /**
     * Our monitor current http client
     * @return OkHttpClient - the http client
     */
    OkHttpClient getClient();
}
