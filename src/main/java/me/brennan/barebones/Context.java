package me.brennan.barebones;

/**
 * @author Brennan / skateboard
 * @since 4/29/2022
 **/
public class Context {
    private static Barebone CURRENT_ENGINE = null;

    public static void newContext(Barebone engine) {
        CURRENT_ENGINE = engine;
    }

    public static Barebone getCurrentEngine() {
        return CURRENT_ENGINE;
    }
}
