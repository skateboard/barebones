package me.brennan.barebones.task.types;

import me.brennan.barebones.task.Task;
import me.brennan.barebones.state.State;
import me.brennan.barebones.state.States;
import okhttp3.OkHttpClient;

import java.util.UUID;

/**
 * @author Brennan / skateboard
 * @since 4/14/2022
 **/
public abstract class AbstractTask implements Task {
    private final UUID uuid = UUID.randomUUID();
    private boolean stopped = false;

    private final OkHttpClient client = new OkHttpClient.Builder().build();

    public AbstractTask() {
    }

    /**
     * This method is called when you want to start the state loops.
     */
    public void runTask() {
        State state = States.INITIALIZE; // our initial state

        while (!stopped) { // while loop when not stopped
            state = this.next(state);

            if (state == States.ERROR) { // if we have an error break the loop.
                System.out.println("Task has encountered a error!");
                break;
            }
        }
    }

    /**
     * This method is called when you want to stop the task.
     */
    @Override
    public State stop() {
        setStopped(true);
        return States.NONE;
    }

    @Override
    public UUID getUUID() {
        return uuid;
    }

    @Override
    public OkHttpClient getClient() {
        return client;
    }

    @Override
    public void setStopped(boolean stopped) {
        this.stopped = stopped;
    }

    @Override
    public boolean isStopped() {
        return stopped;
    }
}
