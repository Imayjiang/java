package com.jiangbo.concurrent.analyse;

/**
 * <p>
 * <p> Date: 2014/8/19 Time: 14:41 </p>
 *
 * @author jiangbo.wjb
 */
public class MockTask implements Runnable {

    private final Object lock;

    public MockTask(final Object lock) {
        this.lock = lock;
    }

    static MockTask getTask(final Object lock) {
        return new MockTask(lock);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" is preparing to enter!");
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName()+" entered!");
            try {
                Thread.sleep(30 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" wake up!");
        }
    }
}
