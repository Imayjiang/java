package com.jiangbo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * <p>
 * <p> Date: 14-4-18 Time: 下午2:22 </p>
 *
 * @author jiangbo.wjb
 */
public class ProxyInstanceFactory {

    public static <T> T newProxyInstance(T source) {
        return (T)java.lang.reflect.Proxy
                .newProxyInstance(
                        source.getClass().getClassLoader(),
                        source.getClass().getInterfaces(),
                        new MyInvocationHandler(source)
                        );
    }

    private static class MyInvocationHandler<T>
            implements InvocationHandler {

        private T source;

        MyInvocationHandler(T source) {
            this.source = source;
        }

        @Override
        public Object invoke(final Object proxy,
                             final Method method,
                             final Object[] args) throws Throwable {
            System.out.println("before method invoked!");
            Object result = method.invoke(source, args);
            System.out.println("after method invoked,but before returned!");
            return result;
        }

    }
}
