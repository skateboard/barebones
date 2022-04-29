import me.brennan.barebones.task.types.AbstractTask;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author Brennan / skateboard
 * @since 4/14/2022
 **/
public class TestTask extends AbstractTask {

    @Override
    public CompletableFuture<?> run() throws ExecutionException, InterruptedException  {
        System.out.println("[TASK] Initializing");
        var initialize = initialize();
        if (!initialize.get()) {
            System.out.println("[TASK] Initializing failed");
            return CompletableFuture.completedFuture(null);
        }
        System.out.println("[TASK] Adding to cart...");
        var atc = addToCart();
        if (!atc.get()) {
            System.out.println("[TASK] Failed to cart.");
            return CompletableFuture.completedFuture(null);
        }
        System.out.println("[TASK] Added To Cart!");

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