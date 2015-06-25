package com.cache.support;

import clojure.lang.Obj;

import java.io.Serializable;

/**
 * </p>
 * Date:2015/5/11   Time:10:54
 *
 * @author: jiangbo.wjb
 */
public class KeyWrapper implements Serializable {

    public final String prefix;

    public final Object key;

    public KeyWrapper(String prefix, Object key) {
        this.prefix = prefix;
        this.key = key;
    }

    public Object get() {
        return this.key;
    }

    public String getPrefix() {
        return prefix;
    }

}
