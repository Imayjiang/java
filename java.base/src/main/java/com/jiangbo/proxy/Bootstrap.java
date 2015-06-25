package com.jiangbo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * <p>
 * <p> Date: 14-4-18 Time: 下午2:21 </p>
 *
 * @author jiangbo.wjb
 */
public class Bootstrap {

    public static void main(String[] args) {
//        testSubject();
        Source proxy = ProxyInstanceFactory.newProxyInstance(new RealSource());
        proxy.test();
    }
}
