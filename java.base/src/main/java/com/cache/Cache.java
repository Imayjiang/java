package com.cache;

/**
 * </p>
 * Date:2015/5/11   Time:10:51
 *
 * @author: jiangbo.wjb
 */
public interface Cache {

    /**
     * get the value specified by the key
     *
     * @param key
     * @return
     */
    public Object get(Object key);

    /**
     * put value to the specified cache target
     *
     * @param key
     * @param value
     * @param expiration expiration timeout by millisecond. If the value is 0, the cache will never expire.
     * @return key if it is null, it is not put into cache successfully
     */
    public String put(Object key, Object value, long expiration);

    /**
     * remove the key from the cache
     *
     * @param key
     * @return
     */
    public String remove(Object key);

    /**
     * Remove all the keys by the key's prefix
     *
     * @param keyPrefix
     * @return the count of entry which is removed
     */
    public int removeByPrefix(String keyPrefix);


}
