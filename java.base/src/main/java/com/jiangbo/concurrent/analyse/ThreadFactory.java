package com.jiangbo.concurrent.analyse;

/**
 * <p>
 *
 * <p> Date: 2014/8/19 Time: 14:45 </p>
 *
 * @author jiangbo.wjb
 */
public class ThreadFactory {

    private static final ThreadFactory INSTANCE = new ThreadFactory();

    static ThreadFactory getInstance() {
        return INSTANCE;
    }

    Thread createThread(int sequence, Runnable task) {
        return new Thread(task,"task_"+sequence);
    }
}
