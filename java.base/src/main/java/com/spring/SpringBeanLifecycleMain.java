package com.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * </p>
 * Date:2015/3/10   Time:16:49
 *
 * @author: jiangbo.wjb
 */
public class SpringBeanLifecycleMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext
                = new ClassPathXmlApplicationContext("classpath:spring/application.xml");
        SpringBeanLiftcycle springBeanLiftcycle
                = (SpringBeanLiftcycle) applicationContext.getBean("springBeanLiftcycle");

    }
}
