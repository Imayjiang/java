package com.jiangbo.concurrent;

/**
 * <p>
 * <p> Date: 14-4-27 Time: 下午8:25 </p>
 *
 * @author jiangbo.wjb
 */
public class ReorderingDemo {

    static int x = 0, y = 0, a = 0, b = 0;

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 100; i++) {
            x = y = a = b = 0;
            Thread one = new Thread("thread-one") {
                @Override
                public void run() {
                    a = 1;
                    x = b;
                    System.out.println("name:" + Thread.currentThread().getName()
                            + "  X:" + x + " Y:" + y);
                }
            };
            Thread two = new Thread("thread-two") {
                @Override
                public void run() {
                    b = 1;
                    y = a;
                    System.out.println("name:" + Thread.currentThread().getName()
                            + "  X:" + x + " Y:" + y);
                }
            };
            one.start();
            two.start();
//            one.join();
//            two.join();
            System.out.println("name:" + Thread.currentThread().getName()
                    + "  X:" + x + " Y:" + y);
        }
    }
}
