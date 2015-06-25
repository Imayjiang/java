package com.jiangbo.concurrent.analyse;

import java.util.Stack;

/**
 * <p>
 *     Thread safe
 * <p> Date: 2014/8/20 Time: 13:56 </p>
 *
 * @author jiangbo.wjb
 */
public class Queue<T> {

    private static final int MAX_CAPACITY = 10;

    private final Stack<T> entities = new Stack<T>();

    void push(T t) {
        synchronized (entities) {
            if (isFull()) {
                System.out.println("full!");
                try {
                    Thread.sleep(5*1000);
                    entities.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            entities.push(t);
            entities.notify();
        }
    }

    T pop() {
        synchronized (entities) {
            if (isEmpty()) {
                System.out.println("empty!");
                try {
                    Thread.sleep(5*1000);
                    entities.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            T t = entities.pop();
            entities.notify();
            return t;
        }
    }

    boolean isEmpty() {
        return entities.isEmpty();
    }

    boolean isFull() {
        return entities.size() == MAX_CAPACITY;
    }

    public int size() {
        return entities.size();
    }
}
