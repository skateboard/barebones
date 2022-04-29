package me.brennan.barebones;

import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import me.brennan.barebones.manager.Manager;
import me.brennan.barebones.manager.impl.AbstractContextMapManager;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Brennan / skateboard
 * @since 4/29/2022
 **/
public abstract class BareboneEngine {
    private Vertx vertx;

    private final List<Manager> managers = new LinkedList<>();

    public abstract void start();

    protected void deploy() {
        this.vertx = Vertx.vertx(new VertxOptions()
                .setBlockedThreadCheckInterval(1)
                .setWorkerPoolSize(5)
                .setMaxWorkerExecuteTime(10)
                .setBlockedThreadCheckIntervalUnit(TimeUnit.HOURS)
                .setMaxWorkerExecuteTimeUnit(TimeUnit.MINUTES)
                .setPreferNativeTransport(true));
        Context.newContext(this);

        managers.forEach(manager -> {
            if (manager instanceof AbstractContextMapManager) {
                ((AbstractContextMapManager<?, ?>) manager).setContext(vertx);
            }
        }); // set all our context managers to use the vertx instance
    }

    public void add(Manager manager) {
        managers.add(manager);
    }

    public Vertx getVertx() {
        return vertx;
    }
}
