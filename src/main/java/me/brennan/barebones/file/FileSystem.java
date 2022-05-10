package me.brennan.barebones.file;

import io.vertx.core.Vertx;

/**
 * @author Brennan / skateboard
 * @since 5/10/2022
 **/
public interface FileSystem<V> {

    V readFile(String path);

    void writeFile(String path, V value);

    void setVertx(Vertx vertx);
}
