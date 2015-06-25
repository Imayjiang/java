package com.jiangbo.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * <p> Date: 14-4-28 Time: 下午12:30 </p>
 *
 * @author jiangbo.wjb
 */
public class Executors {

    static {
        int count = Runtime.getRuntime().availableProcessors();
    }

    private static final ExecutorService LEADER_EXECUTOR
            = new ThreadPoolExecutor(Constants.LEADER_CORE_POOL_SIZE,
            Constants.LEADER_MAX_POOL_SIZE,
            Constants.LEADER_THREAD_KEEP_ALIVE_SECONDS,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<Runnable>(Constants.LEADER_TASK_QUEUE_SIZE)
    );

    private static final ExecutorService WORKER_EXECUTOR
            = new ThreadPoolExecutor(Constants.WORKER_CORE_POOL_SIZE,
            Constants.WORKER_MAX_POOL_SIZE,
            Constants.WORKER_THREAD_KEEP_ALIVE_SECONDS,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<Runnable>(Constants.WORKER_TASK_QUEUE_SIZE)
    );

    public static ExecutorService leaderExecutor() {
        return LEADER_EXECUTOR;
    }

    public static ExecutorService workExecutor() {
        return WORKER_EXECUTOR;
    }


    static interface Constants {


        /**
         * 最坏情况下，每分钟只能处理 60S / 3SPer笔 * 10条线程 = 200笔
         */
        int LEADER_CORE_POOL_SIZE = 2;
        int LEADER_MAX_POOL_SIZE = 10;
        int LEADER_TASK_QUEUE_SIZE = 20;

        long LEADER_THREAD_KEEP_ALIVE_SECONDS = 60;

        int WORKER_CORE_POOL_SIZE = 2;
        int WORKER_MAX_POOL_SIZE = 15;
        int WORKER_TASK_QUEUE_SIZE = 30;

        long WORKER_THREAD_KEEP_ALIVE_SECONDS = 60;
    }
}
