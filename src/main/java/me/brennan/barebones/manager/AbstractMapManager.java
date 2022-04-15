package me.brennan.barebones.manager;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Brennan / skateboard
 * @since 4/14/2022
 **/
public class AbstractMapManager<K, V> implements Iterable<V> {
    private final Map<K, V> map = new LinkedHashMap<>();

    public void add(K key, V value) {
        map.put(key, value);
    }

    public void remove(K key) {
        map.remove(key);
    }

    public V get(K key) {
        return map.get(key);
    }

    @NotNull
    @Override
    public Iterator<V> iterator() {
        return map.values().iterator();
    }
}
