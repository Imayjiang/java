package com.jiangbo.concurrent.variable.shared;

/**
 * <p>
 * <p> Date: 14-5-10 Time: 下午6:15 </p>
 *
 * @author jiangbo.wjb
 */
public class ServiceImp implements Service {

    private volatile Cache cache = Cache.Builder.newCache(null, null);

    @Override
    public void service(final Request req) throws InterruptedException {
        final String name = req.name;
        String value = cache.getValue(name);
        Thread.sleep(10);
        if (value == null) {
            System.out.println("before:" + cache
                    + "==========current thread:" + Thread.currentThread().getName());
            final String key = Cache.KEY;
            cache = Cache.Builder.newCache(key, Thread.currentThread().getName());
            System.out.println("\n after:" + cache
                    + "==========current thread:" + Thread.currentThread().getName());
        }
    }

}
