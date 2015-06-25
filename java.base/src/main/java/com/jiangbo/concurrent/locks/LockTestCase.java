package com.jiangbo.concurrent.locks;

import com.jiangbo.concurrent.Lock;

import java.lang.reflect.*;

/**
 * <p>
 * <p> Date: 2014/7/30 Time: 13:05 </p>
 *
 * @author jiangbo.wjb
 */
public class LockTestCase {

    private Lock lock;

    public LockTestCase() {
        initLock();
    }

    private void initLock() {
        lock = Locks.mcsLock();
    }

    public static void main(String[] args) {
        LockTestCase testCase = new LockTestCase();
//        for (int i = 0; i < 5; i++) {
//            {
                testCase.testWithNewThreads(new Counter(0), 20);
//            }
//        }

    }

    private void testWithNewThreads(final Counter counter,
                                    final int taskCount) {
        for (int i = 0; i < taskCount; i++) {
            new Thread(getTask(counter)).start();
        }
    }

    public Runnable getTask(final Counter counter) {
        return new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    counter.increase();
                    System.out.println("Thread:" + Thread.currentThread().getName()
                            + " num:" + counter.num + "\n");
                } finally {
                    lock.unlock();
                }

            }
        };

    }


    static class Counter {

        int num;

        Counter(final int num) {
            this.num = num;
        }

        void increase() {
            num++;
        }
    }
}
