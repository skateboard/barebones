import me.brennan.barebones.task.types.AbstractTask;
import me.brennan.barebones.state.State;
import me.brennan.barebones.state.States;

import java.util.concurrent.TimeUnit;

/**
 * @author Brennan / skateboard
 * @since 4/14/2022
 **/
public class TestTask extends AbstractTask {

    @Override
    public State next(State state) {
        if (States.INITIALIZE.equals(state)) {
            System.out.println("Initializing");

            return TaskState.ADD_TO_CART;
        } else if (TaskState.ADD_TO_CART.equals(state)) {
            System.out.println("Adding to cart");

            return addToCart();
        } else if (TaskState.FAILED_ADD_TO_CART.equals(state)) {
            System.out.println("Failed to add to cart");
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
        ADD_TO_CART,
        FAILED_ADD_TO_CART;
    }
}
