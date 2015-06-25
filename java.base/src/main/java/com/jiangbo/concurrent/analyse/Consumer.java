package com.jiangbo.concurrent.analyse;

/**
 * <p>
 * <p> Date: 2014/8/20 Time: 13:01 </p>
 *
 * @author jiangbo.wjb
 */
public class Consumer implements Runnable {

    private final Queue<Object> queue;

    Consumer(final Queue<Object> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            queue.pop();
        }
    }

}
