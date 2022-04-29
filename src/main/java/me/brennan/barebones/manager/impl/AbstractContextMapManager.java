package me.brennan.barebones.manager.impl;

import io.vertx.core.Vertx;
import me.brennan.barebones.manager.Manager;

/**
 * @author Brennan / skateboard
 * @since 4/29/2022
 **/
public abstract class AbstractContextMapManager<K, V> extends MapManager<K, V> implements Manager {
    private Vertx vertx;

    public void setContext(Vertx vertx) {
        this.vertx = vertx;
    }

    public Vertx getContext() {
        return vertx;
    }
}
