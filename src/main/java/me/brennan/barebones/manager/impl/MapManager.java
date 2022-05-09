package me.brennan.barebones.manager.impl;

import me.brennan.barebones.manager.Manager;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Brennan / skateboard
 * @since 4/14/2022
 **/
public class MapManager<K, V> implements Iterable<V>, Manager {
    private final ReentrantReadWriteLock mutex = new ReentrantReadWriteLock();
    private final Lock readLock = mutex.readLock();
    private final Lock writeLock = mutex.writeLock();

    private final Map<K, V> map = new LinkedHashMap<>();

    public void add(K key, V value) {
        writeLock.lock();

        try {
            map.put(key, value);
        } finally {
            writeLock.unlock();
        }
    }

    public void remove(K key) {
        writeLock.lock();

        try {
            map.remove(key);
        } finally {
            writeLock.unlock();
        }
    }

    public V get(K key) {
        readLock.lock();

        try {
            return map.get(key);
        } finally {
            readLock.unlock();
        }
    }

    public boolean contains(K key) {
        readLock.lock();

        try {
            return map.containsKey(key);
        } finally {
            readLock.unlock();
        }
    }

    public void clear() {
        writeLock.lock();

        try {
            map.clear();
        } finally {
            writeLock.unlock();
        }
    }

    public int size() {
        readLock.lock();

        try {
            return map.size();
        } finally {
            readLock.unlock();
        }
    }

    public boolean isEmpty() {
        readLock.lock();

        try {
            return map.isEmpty();
        } finally {
            readLock.unlock();
        }
    }

    public Collection<V> values() {
        readLock.lock();

        try {
            return map.values();
        } finally {
            readLock.unlock();
        }
    }

    @NotNull
    @Override
    public Iterator<V> iterator() {
        return values().iterator();
    }
}
