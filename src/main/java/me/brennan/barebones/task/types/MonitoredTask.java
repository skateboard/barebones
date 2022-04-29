package me.brennan.barebones.task.types;

import me.brennan.barebones.product.Product;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author Brennan / skateboard
 * @since 4/14/2022
 **/
public abstract class MonitoredTask extends AbstractTask {
    private CompletableFuture<Product> monitorPromise;

    public Product waitForMonitor() {
        if (monitorPromise == null) {
            monitorPromise = new CompletableFuture<>();
        }

        try {
            return monitorPromise.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void notifyTask(Product product) {
        monitorPromise.complete(product);
    }

}
