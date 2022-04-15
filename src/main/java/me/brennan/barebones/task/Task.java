package me.brennan.barebones.task;

import me.brennan.barebones.state.State;
import okhttp3.OkHttpClient;

import java.util.UUID;

/**
 * @author Brennan / skateboard
 * @since 4/14/2022
 **/
public interface Task {

    UUID getUUID();

    State stop();

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
     * Our task current state to run
     *
     * example: ADD TO CART
     *
     * @param state - the state of the task
     * @return the next state to run
     */
    State next(State state);

    /**
     * Our task current http client
     * @return OkHttpClient - the http client
     */
    OkHttpClient getClient();
}