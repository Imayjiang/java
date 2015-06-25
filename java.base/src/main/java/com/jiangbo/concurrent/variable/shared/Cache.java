package com.jiangbo.concurrent.variable.shared;

/**
 * <p>
 * <p> Date: 14-5-10 Time: 下午6:16 </p>
 *
 * @author jiangbo.wjb
 */
public class Cache {

    static final String KEY = "测试";

    private final String key;

    private final String value;

    private Cache(final String key, final String value) {
        this.key = key;
        this.value = value;
    }

    String getValue(final String name) {
        if (name == null) {
            throw new NullPointerException();
        }
        return name.equalsIgnoreCase(this.key) ? this.value : null;
    }

    @Override
    public String toString() {
        return "" + key + " _" + value;
    }

    public static class Builder {

        public static Cache newCache(String key, String value) {
            return new Cache(key, value);
        }
    }
}
