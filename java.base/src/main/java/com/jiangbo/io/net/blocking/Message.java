package com.jiangbo.io.net.blocking;

import java.io.Serializable;

/**
 * <p>
 * <p> Date: 2014/7/1 Time: 17:43 </p>
 *
 * @author jiangbo.wjb
 */
public class Message implements Serializable {

    private final int age;

    public Message(final int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "" + age;
    }
}
