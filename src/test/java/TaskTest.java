import me.brennan.test.TestEngine;
import org.junit.jupiter.api.Test;

/**
 * @author Brennan / skateboard
 * @since 4/14/2022
 *
 * This would normally be a main class in a main method, but I'm just testing
 **/
public class TaskTest {

    @Test
    public void testTask() {
        final TestEngine engine = new TestEngine();
        engine.start();

        while (true);
    }
}
