import me.brennan.barebones.monitor.AbstractMonitor;
import me.brennan.barebones.state.State;
import me.brennan.barebones.state.States;

import java.util.concurrent.TimeUnit;

/**
 * @author Brennan / skateboard
 * @since 4/14/2022
 **/
public class TestMonitor extends AbstractMonitor {

    @Override
    public State next(State state) {
        if (States.INITIALIZE.equals(state)) {
            System.out.println("[MONITOR] Initializing");

            return MonitorState.GET_PRODUCT_INFO;
        } else if (MonitorState.GET_PRODUCT_INFO.equals(state)) {
            System.out.println("[MONITOR] Getting product info");
            return getProductInfo();
        } else if (MonitorState.FAILED_GET_PRODUCT_INFO.equals(state)) {
            System.out.println("[MONITOR] Failed to get product info");
            return this.stop();
        } else if (MonitorState.SUCCESSFUL_GOT_PRODUCT_INFO.equals(state)) {
            System.out.println("[MONITOR] Got product info");
            System.out.println("[MONITOR] notifying tasks");

            this.notifyTasks();

            return this.stop();
        }

        return States.ERROR;
    }

    private MonitorState getProductInfo() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return MonitorState.SUCCESSFUL_GOT_PRODUCT_INFO;
    }

    private enum MonitorState implements State {
        GET_PRODUCT_INFO,
        FAILED_GET_PRODUCT_INFO,
        SUCCESSFUL_GOT_PRODUCT_INFO
    }
}
