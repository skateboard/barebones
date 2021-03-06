package me.brennan.test.tasks;

import me.brennan.barebones.task.types.AbstractTask;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author Brennan / skateboard
 * @since 4/29/2022
 **/
public class TestTask extends AbstractTask {

    @Override
    public CompletableFuture<?> run() throws ExecutionException, InterruptedException  {
        System.out.println("[TASK] Initializing");
        var initialize = initialize();
        if (!initialize.join()) {
            System.out.println("[TASK] Initializing failed");
            return CompletableFuture.completedFuture(null);
        }
        System.out.println("[TASK] Adding to cart...");
        var atc = addToCart();
        if (!atc.join()) {
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