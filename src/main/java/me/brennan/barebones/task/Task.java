package me.brennan.barebones.task;

import me.brennan.barebones.http.Client;
import me.brennan.barebones.proxy.ProxyList;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author Brennan / skateboard
 * @since 4/14/2022
 **/
public interface Task {

    UUID getUUID();

    CompletableFuture<?> run() throws ExecutionException, InterruptedException;

    void stop();

    /**
     * @return is the task stopped
     */
    boolean isStopped();

    /**
     * Sets the task to stopped
     * @param stopped - true if stopped
     */
    void setStopped(boolean stopped);

    /**
     * The proxy list the task is using
     *
     * @return the proxy list
     */
    ProxyList getProxyList();

    /**
     * Our task current http client
     * @return OkHttpClient - the http client
     */
    Client getClient();

    default void sleep(long millis) {
        try {
            TimeUnit.SECONDS.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}