package me.brennan.test.monitors;

import me.brennan.barebones.monitor.AbstractMonitor;
import me.brennan.barebones.product.provided.SimpleProduct;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author Brennan / skateboard
 * @since 4/29/2022
 **/
public class TestMonitor extends AbstractMonitor {

    @Override
    public CompletableFuture<?> run() throws ExecutionException, InterruptedException {
        System.out.println("[MONITOR] Initializing");
        var initialize = initialize();
        if (!initialize.get()) {
            return CompletableFuture.completedFuture(null);
        }
        System.out.println("[MONITOR] Getting product info");
        var productInfo = getProductInfo();
        if (!productInfo.get()) {
            return CompletableFuture.completedFuture(null);
        }
        System.out.println("[MONITOR] Got product info");
        System.out.println("[MONITOR] Notifying tasks");

        this.notifyTasks(new SimpleProduct("Test Product", "12345", "aasd1231", 20.00, 0));

        return CompletableFuture.completedFuture(null);
    }

    private CompletableFuture<Boolean> getProductInfo() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return true;
        });
    }

    private CompletableFuture<Boolean> initialize() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return true;
        });
    }

}