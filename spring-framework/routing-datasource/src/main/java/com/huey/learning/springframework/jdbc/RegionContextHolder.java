package com.huey.learning.springframework.jdbc;

/**
 * @author huey
 */
public class RegionContextHolder {

    /**
     * uses ThreadLocal to hold the region reference so that the context is bound to the currently executing thread.
     */
    private static ThreadLocal<Region> CONTEXT = new ThreadLocal<>();

    /**
     * sets the region
     *
     * @param region
     */
    public static void set(Region region) {
        CONTEXT.set(region);
    }

    /**
     * gets the region
     *
     * @return
     */
    public static Region get() {
        return CONTEXT.get();
    }

    /**
     * removes the region
     */
    public static void clear() {
        CONTEXT.remove();
    }

}
