package me.brennan.barebones.task.types;

import io.vertx.core.AbstractVerticle;
import me.brennan.barebones.http.Client;
import me.brennan.barebones.proxy.ProxyList;
import me.brennan.barebones.task.Task;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

/**
 * @author Brennan / skateboard
 * @since 4/14/2022
 **/
public abstract class AbstractTask extends AbstractVerticle implements Task {
    private final UUID uuid;
    private boolean stopped = false;

    private ProxyList proxyList;

    private Client client;

    public AbstractTask() {
        this.uuid = UUID.randomUUID();

        this.client = new Client(getVertx());
    }

    @Override
    public void start() throws ExecutionException, InterruptedException {
        run().whenComplete((result, error) -> this.vertx.undeploy(super.deploymentID())).exceptionally(throwable -> null);
    }

    /**
     * This method is called when you want to stop the task.
     */
    @Override
    public void stop() {
        setStopped(true);
    }

    @Override
    public UUID getUUID() {
        return uuid;
    }

    @Override
    public ProxyList getProxyList() {
        return proxyList;
    }

    @Override
    public Client getClient() {
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
