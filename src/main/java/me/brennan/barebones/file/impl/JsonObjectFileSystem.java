package me.brennan.barebones.file.impl;

import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.json.JsonObject;
import me.brennan.barebones.file.FileSystem;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Brennan / skateboard
 * @since 5/10/2022
 **/
public class JsonObjectFileSystem implements FileSystem<JsonObject> {
    private Vertx vertx;

    @Override
    public JsonObject readFile(String path) {
        var json = new AtomicReference<>(new JsonObject());

        vertx.fileSystem().readFile(path, res -> {
            if (res.succeeded()) {
                json.set(new JsonObject(res.result()));
            } else {
                json.set(null);
            }
        });

        return json.get();
    }

    @Override
    public void writeFile(String path, JsonObject value) {
        vertx.fileSystem().writeFile(path, Buffer.buffer(value.toString()));
    }

    @Override
    public void setVertx(Vertx vertx) {
        this.vertx = vertx;
    }
}
