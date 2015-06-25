package com.jiangbo.concurrent.analyse;

import java.lang.reflect.Field;

/**
 * <p>
 * <p> Date: 2014/8/20 Time: 12:58 </p>
 *
 * @author jiangbo.wjb
 */
public class Producer implements Runnable {

    private final Queue<Object> queue;

    Producer(final Queue<Object> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            queue.push(newConsumerGoods());
        }
    }

    private Object newConsumerGoods() {
        return new Object();
    }

}
