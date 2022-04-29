import me.brennan.barebones.task.types.MonitoredTask;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author Brennan / skateboard
 * @since 4/14/2022
 **/
public class TestMonitorTask extends MonitoredTask {

    @Override
    public CompletableFuture<?> run() throws ExecutionException, InterruptedException {
        System.out.println("[TASK] Initializing");
        var initialize = initialize();
        if (!initialize.get()) {
            return CompletableFuture.completedFuture(null);
        }
        System.out.println("[TASK] Waiting for monitor...");
        var monitorProduct = waitForMonitor();
        if (monitorProduct == null) {
            System.out.println("[TASK] Monitored has failed.");
            return CompletableFuture.completedFuture(null);
        }
        System.out.println("[TASK] Product found");
        System.out.println(monitorProduct.getName());
        System.out.println(monitorProduct.getSku());
        System.out.println(monitorProduct.getPrice());

        System.out.println("[TASK] Adding to cart.");
        var atc = addToCart();
        if (!atc.get()) {
            System.out.println("[TASK] Failed to add to cart.");
            return CompletableFuture.completedFuture(null);
        }
        System.out.println("[TASK] Added to cart.");

        return CompletableFuture.completedFuture(null);
    }

    private CompletableFuture<Boolean> addToCart() {
        return CompletableFuture.supplyAsync(() -> {
            sleep(2);

            return false;
        });
    }

    private CompletableFuture<Boolean> initialize() {
        return CompletableFuture.supplyAsync(() -> {
            sleep(2);

            return true;
        });
    }

}
