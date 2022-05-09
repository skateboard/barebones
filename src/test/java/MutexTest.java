import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Brennan / skateboard
 * @since 5/8/2022
 **/
public class MutexTest {
    private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);

    private static final Map<String, String> map = new HashMap<>();

    public static void main(String[] args) {
        for (int i = 0; i < 500; i++) {
            int finalI = i;
            new Thread(() -> work(finalI)).start();
        }

        while (true) {
            if (size() == 500) {
                break;
            }
        }

        System.out.println(size());
    }

    private static int size() {
        lock.readLock().lock();
        var size = map.size();
        lock.readLock().unlock();

        return size;
    }

    private static void work(int i) {
        lock.writeLock().lock();
        map.put("key-" + i, "value-" + i);
        lock.writeLock().unlock();
    }
}
