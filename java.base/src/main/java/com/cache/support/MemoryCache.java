package com.cache.support;

import com.cache.Cache;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * </p>
 * Date:2015/5/11   Time:11:07
 *
 * @author: jiangbo.wjb
 */
public class MemoryCache implements Cache {

    private ConcurrentMap memoryCache = new ConcurrentHashMap();

    @Override
    public Object get(Object key) {
        return null;
    }

    @Override
    public String put(Object key, Object value, long expiration) {
        return null;
    }

    @Override
    public String remove(Object key) {
        return null;
    }

    @Override
    public int removeByPrefix(String keyPrefix) {
        return 0;
    }
}
