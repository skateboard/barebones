import me.brennan.barebones.state.State;
import me.brennan.barebones.state.States;
import me.brennan.barebones.task.types.MonitoredTask;

import java.util.concurrent.TimeUnit;

/**
 * @author Brennan / skateboard
 * @since 4/14/2022
 **/
public class TestMonitorTask extends MonitoredTask {

    @Override
    public State next(State state) {
        if (States.INITIALIZE.equals(state)) {
            System.out.println("[TASK] Initializing");

            return TaskState.WAIT_FOR_MONITOR;
        } else if (TaskState.WAIT_FOR_MONITOR.equals(state)) {
            System.out.println("[TASK] Waiting for monitor...");

            this.waitForMonitor();

            return TaskState.ADD_TO_CART;
        } else if (TaskState.ADD_TO_CART.equals(state)) {
            System.out.println("[TASK] Adding to cart");

            return addToCart();
        } else if (TaskState.FAILED_ADD_TO_CART.equals(state)) {
            System.out.println("[TASK] Failed to add to cart");
            return this.stop();
        }

        return States.ERROR;
    }

    private TaskState addToCart() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return TaskState.FAILED_ADD_TO_CART;
    }

    private enum TaskState implements State {
        WAIT_FOR_MONITOR,
        ADD_TO_CART,
        FAILED_ADD_TO_CART
    }
}
