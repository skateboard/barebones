package me.brennan.barebones.proxy;

import me.brennan.barebones.util.MathUtil;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.List;

/**
 * @author Brennan / skateboard
 * @since 4/14/2022
 **/
public class ProxyList implements Iterable<Proxy> {
    private final List<Proxy> proxies;

    public ProxyList(List<Proxy> proxies) {
        this.proxies = proxies;
    }

    public void add(Proxy proxy) {
        proxies.add(proxy);
    }

    public void remove(Proxy proxy) {
        proxies.remove(proxy);
    }

    public Proxy randomProxy() {
        if(proxies.isEmpty())
            return null;

        final Proxy proxy = proxies.get(MathUtil.RANDOM.nextInt(proxies.size()));
        proxies.remove(proxy); // Remove the proxy from the list so it can't be used again.

        return proxy;
    }

    @NotNull
    @Override
    public Iterator<Proxy> iterator() {
        return proxies.iterator();
    }
}
