package me.brennan.barebones.manager.impl;

import me.brennan.barebones.manager.Manager;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Brennan / skateboard
 * @since 4/14/2022
 **/
public class MapManager<K, V> implements Iterable<V>, Manager {
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

    public boolean contains(K key) {
        return map.containsKey(key);
    }

    public void clear() {
        map.clear();
    }

    public int size() {
        return map.size();
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }

    @NotNull
    @Override
    public Iterator<V> iterator() {
        return map.values().iterator();
    }
}
