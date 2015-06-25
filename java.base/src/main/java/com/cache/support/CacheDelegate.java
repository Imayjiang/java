package com.cache.support;

import com.cache.Cache;

/**
 * </p>
 * Date:2015/5/11   Time:11:07
 *
 * @author: jiangbo.wjb
 */
public class CacheDelegate implements Cache {

    private Cache delegatedCache;

    public CacheDelegate(final Cache delegatedCache) {
        this.delegatedCache = delegatedCache;
    }

    @Override
    public Object get(Object key) {
        return delegatedCache.get(key);
    }

    @Override
    public String put(Object key, Object value, long expiration) {
        return delegatedCache.put(key, value, expiration);
    }

    @Override
    public String remove(Object key) {
        return delegatedCache.remove(key);
    }

    @Override
    public int removeByPrefix(String keyPrefix) {
        return delegatedCache.removeByPrefix(keyPrefix);
    }
}
