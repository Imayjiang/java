package com.jiangbo.concurrent;

/**
 * <p>
 * <p> Date: 14-5-13 Time: 上午11:46 </p>
 *
 * @author jiangbo.wjb
 */
public class MonitorLockDemo {

    private final Object LOCK = new Object();

    public static void main(String[] args) throws InterruptedException {
        final MonitorLockDemo demo = new MonitorLockDemo();
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        demo.doSomething();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            ).start();
        }
    }

    private void doSomething() throws InterruptedException {
        synchronized (LOCK) {
            System.out.println("thread:" + Thread.currentThread().getName()
                                + "=========pending waiting");
//            if(!precondition) {
                LOCK.wait(5*1000);
//            }
            System.out.println("thread:" + Thread.currentThread().getName()
                    + "=========waiting");
            Thread.sleep(5*1000);
           // LOCK.notifyAll();
            System.out.println("thread:" + Thread.currentThread().getName()
                    + "=========notify");
        }
    }
}
