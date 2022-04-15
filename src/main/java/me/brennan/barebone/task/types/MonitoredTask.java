package me.brennan.barebone.task.types;

import java.util.concurrent.TimeUnit;

/**
 * @author Brennan / skateboard
 * @since 4/14/2022
 **/
public abstract class MonitoredTask extends AbstractTask {
    private boolean notified = false; // just for debugging purposes right now, will make a product object maybe?

    public void waitForMonitor() {
        while (!notified) {
            // wait for the monitor to notify us
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void notifyTask() {
        notified = true;
    }

}
