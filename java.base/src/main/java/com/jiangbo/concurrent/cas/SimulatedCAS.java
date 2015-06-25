package com.jiangbo.concurrent.cas;

/**
 * <p>
 * <p> Date: 14-5-19 Time: 下午9:15 </p>
 *
 * @author jiangbo.wjb
 */
public class SimulatedCAS {

    private int value;

    SimulatedCAS(final int v) {
        this.value = v;
    }

    public synchronized int get() {
        return value;
    }

    synchronized int compareAndSwap(final int expectedValue,
                                    final int newValue) {
        final int oldValue = value;
        if (oldValue == expectedValue) {
            value = newValue;
        }
        return oldValue;
    }

    synchronized boolean compareAndSet(final int expectedValue,
                                       final int newValue) {
        return expectedValue
                == compareAndSwap(expectedValue, newValue);
    }
}
