package com.jiangbo.concurrent.variable.shared;

/**
 * <p>
 * <p> Date: 14-5-10 Time: 下午6:12 </p>
 *
 * @author jiangbo.wjb
 */
public class ImmutableDemo {

    public static void main(String[] args) {

        final Service service = new ServiceImp();
        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        service.service(new Request(Cache.KEY));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        }
    }


}
