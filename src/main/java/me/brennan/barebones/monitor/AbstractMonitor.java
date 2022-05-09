package me.brennan.barebones.monitor;

import io.vertx.core.AbstractVerticle;
import me.brennan.barebones.http.Client;
import me.brennan.barebones.product.Product;
import me.brennan.barebones.task.types.MonitoredTask;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

/**
 * @author Brennan / skateboard
 * @since 4/14/2022
 **/
public abstract class AbstractMonitor extends AbstractVerticle implements Monitor {
    private final UUID uuid;
    private boolean stopped = false;

    private final List<MonitoredTask> tasks = new LinkedList<>();

    private final Client client;

    public AbstractMonitor() {
        this.uuid = UUID.randomUUID();

        this.client = new Client(getVertx());
    }

    @Override
    public void start() throws ExecutionException, InterruptedException {
        run().whenComplete((result, error) -> this.vertx.undeploy(super.deploymentID())).exceptionally(throwable -> null);
    }

    @Override
    public void stop() {
        setStopped(true);
    }

    public void addTask(MonitoredTask task) {
        tasks.add(task);
    }

    @Override
    public UUID getUUID() {
        return uuid;
    }

    @Override
    public Client getClient() {
        return client;
    }

    @Override
    public boolean isStopped() {
        return stopped;
    }

    @Override
    public void setStopped(boolean stopped) {
        this.stopped = stopped;
    }

    public void notifyTasks(Product product) {
        for (MonitoredTask task : tasks) {
            task.notifyTask(product);
        }
    }

    @Override
    public List<MonitoredTask> getTasks() {
        return tasks;
    }
}
