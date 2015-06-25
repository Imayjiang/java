package com.spring;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ApplicationObjectSupport;

/**
 * <p>
 * </p>
 * <p> Date: 2014/11/25 Time: 11:47 </p>
 *
 * @author jiangbo.wjb
 */
public class BeanFactoryHolder {

    private static ApplicationContext applicationContext;

    private static AutowireCapableBeanFactory beanFactory;

    public static void init(ApplicationObjectSupport springContextAwarer) {
        applicationContext = springContextAwarer.getApplicationContext();
        beanFactory = applicationContext.getAutowireCapableBeanFactory();
    }

    private static BeanFactoryHolder INSTANCE;

    private BeanFactoryHolder() {
        INSTANCE = this;
    }

    public static BeanFactoryHolder getInstance() {
        if (INSTANCE == null) {
            synchronized (BeanFactoryHolder.class) {
                if (INSTANCE == null) {
                    INSTANCE = new BeanFactoryHolder();
                }
            }
        }
        return INSTANCE;
    }

    public <T> void bean(T bean) {
        beanFactory.autowireBean(bean);
    }

}
