package com.jiangbo.concurrent.cas;

/**
 * <p>
 * <p> Date: 2014/6/15 Time: 22:58 </p>
 *
 * @author jiangbo.wjb
 */
public class CASTestCase {

    public static void main(String[] args) {
        final CASCounter counter = new CASCounter(0);
        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("name:" + Thread.currentThread().getName()
                            + " count:" + counter.incrementAndGet() + "\n");
                }
            }).start();
        }
    }
}
