package com.jiangbo.concurrent;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 * <p> Date: 14-4-29 Time: 上午9:56 </p>
 *
 * @author jiangbo.wjb
 */
public class LockDemo {

    private final ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {
        final Counter counter = new Counter(0);
        LockDemo demo = new LockDemo();
        final int taskCount = 10;
        demo.testWithNewThreads(counter, taskCount);
        System.out.println("----------------------------------********************-----------------------------\n");
        demo.testWithExecutor(counter, taskCount);
    }

    private void testWithNewThreads(final Counter counter,
                                    final int taskCount) {

        for (int i = 0; i < taskCount; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    getTask(counter);
                }
            }).start();
        }
    }

    private void testWithExecutor(final Counter counter,
                                  final int taskCount) {
        final ExecutorService executor
                = java.util.concurrent.Executors.newFixedThreadPool(taskCount);
        for (int i = 0; i < taskCount; i++) {
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    getTask(counter);
                }
            });
        }
    }

    public void getTask(final Counter counter) {
        final ReentrantLock lock = reentrantLock;
        try {
            lock.lock();
            System.out.println("========before=========\n" + lock.toString()
                    + "Thread:" + Thread.currentThread().getName()
                    + " count:" + counter.getCount());
            counter.increase();
            System.out.println("************middle**********\n" + lock.toString()
                    + "Thread:" + Thread.currentThread().getName()
                    + " count:" + counter.getCount() + "\n"
                    + "==============after==============\n" + lock.toString());

        } finally {
            lock.unlock();
        }
    }


    static class Counter {

        Counter(final int count) {
            this.count = count;
        }

        public int getCount() {
            return count;
        }

        private int count;

        void increase() {
            count++;
        }
    }
}
