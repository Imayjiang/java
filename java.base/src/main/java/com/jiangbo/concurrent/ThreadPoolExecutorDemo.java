package com.jiangbo.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import static com.jiangbo.concurrent.Executors.Constants.*;

/**
 * <p>
 * <p> Date: 14-4-28 Time: 下午12:42 </p>
 *
 * @author jiangbo.wjb
 */
public class ThreadPoolExecutorDemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        final ExecutorService executor
                = Executors.leaderExecutor();
        final CountDownLatch latch
                = new CountDownLatch(LEADER_MAX_POOL_SIZE);
        for (int i = 0; i < LEADER_MAX_POOL_SIZE; i++) {
            final int j = i;
            Integer result = 10;
            Future<Integer> future = executor.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("i:" + j
                            + " threadName:" + Thread.currentThread().getName());
                    latch.countDown();
                }
            },result);
            Integer res = future.get();
            System.out.println(res);
        }
        System.out.println("start------------------");
        latch.await();
        System.out.println("finish------------------");
    }
}
