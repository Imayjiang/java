package com.jiangbo.concurrent.analyse;

import com.jiangbo.serialization.ObjectIO;

/**
 * <p>
 * <p> Date: 2014/8/20 Time: 14:17 </p>
 *
 * @author jiangbo.wjb
 */
public class Main {

    public static void main(String[] args) {
        Queue<Object> queue = new Queue<Object>();
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        new Thread(producer,"producer thread").start();
        new Thread(consumer,"consumer thread").start();
        while (true) {
            System.out.println(queue.size());
        }

    }
}
