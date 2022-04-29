package me.brennan.barebones.monitor;

import me.brennan.barebones.http.Client;
import me.brennan.barebones.task.types.MonitoredTask;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author Brennan / skateboard
 * @since 4/14/2022
 **/
public interface Monitor {

    UUID getUUID();

    List<MonitoredTask> getTasks();

    CompletableFuture<?> run() throws ExecutionException, InterruptedException;

    void stop();

    boolean isStopped();

    void setStopped(boolean stopped);


    /**
     * Our monitor current http client
     * @return OkHttpClient - the http client
     */
    Client getClient();
}
