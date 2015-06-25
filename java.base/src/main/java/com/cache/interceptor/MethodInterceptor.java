package com.cache.interceptor;

import java.lang.reflect.Method;

/**
 * </p>
 * Date:2015/5/11   Time:10:57
 *
 * @author: jiangbo.wjb
 */
public interface MethodInterceptor {

    Object invoke(Object source, Method method,
                  Object proxy, Object[] args) throws Throwable;
}
