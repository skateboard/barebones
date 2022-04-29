package me.brennan.barebones;

/**
 * @author Brennan / skateboard
 * @since 4/29/2022
 **/
public class Context {
    private static BareboneEngine CURRENT_ENGINE = null;

    public static void newContext(BareboneEngine engine) {
        CURRENT_ENGINE = engine;
    }

    public static BareboneEngine getCurrentEngine() {
        return CURRENT_ENGINE;
    }
}
