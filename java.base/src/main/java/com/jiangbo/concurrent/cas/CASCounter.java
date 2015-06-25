package com.jiangbo.concurrent.cas;

/**
 * <p>
 * <p> Date: 14-5-19 Time: 下午9:22 </p>
 *
 * @author jiangbo.wjb
 */
public class CASCounter {

    private final SimulatedCAS value;

    CASCounter(final int v) {
        value = new SimulatedCAS(v);
    }

    public int getValue() {
        return value.get();
    }

    public int getAndIncrement() {
        int v;
        do {
            v = value.get();
            System.out.println("original:"
                    + Thread.currentThread().getName()
                    + " count:" + v + "=================");
        } while (!value.compareAndSet(v, v + 1));
        return v;
    }

    public int incrementAndGet() {
        int v;
        do {
            v = value.get();
            System.out.println("original:" + Thread.currentThread().getName()
                    + " count:" + v + "=================");
        } while (!value.compareAndSet(v, v + 1));
        return value.get();
    }


}
