package com.jiangbo.concurrent.analyse;

/**
 * <p>
 * <p> Date: 2014/8/19 Time: 11:17 </p>
 *
 * @author jiangbo.wjb
 */
public class ThreadInfoAnalyseDemo {

    private final Object lock = new Object();

    public static void main(String[] args) {
        ThreadInfoAnalyseDemo demo = new ThreadInfoAnalyseDemo();
        demo.analyseThread();
    }

    private void analyseThread() {
        final int taskSize = 10;
        MockTask[] tasks = new MockTask[taskSize];
        for (int index = 0; index < taskSize; index++) {
            tasks[index] = MockTask.getTask(lock);
            ThreadFactory.getInstance().createThread(index, tasks[index]).start();
        }
    }
}
