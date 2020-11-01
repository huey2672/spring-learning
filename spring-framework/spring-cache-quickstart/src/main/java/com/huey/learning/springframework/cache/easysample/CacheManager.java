package com.huey.learning.springframework.cache.easysample;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CacheManager<T> {

    private Map<String, T> cache = new ConcurrentHashMap<>();

    /**
     * get value from cache
     *
     * @param key
     * @return
     */
    public T getValue(String key) {
        return cache.get(key);
    }

    /**
     * set value to cache
     *
     * @param key
     * @param value
     */
    public void setValue(String key, T value) {
        cache.put(key, value);
    }

    /**
     * remove a key
     *
     * @param key
     */
    public void evictCache(String key) {
        if (cache.containsKey(key)) {
            cache.remove(key);
        }
    }

    /**
     * clear the cache
     */
    public void evictCache() {
        cache.clear();
    }

}