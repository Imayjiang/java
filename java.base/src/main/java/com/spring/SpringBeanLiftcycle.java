package com.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.w3c.dom.Element;

import javax.annotation.Resource;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * </p>
 * Date:2015/3/10   Time:16:41
 *
 * @author: jiangbo.wjb
 */
public class SpringBeanLiftcycle implements
//        BeanNameAware, BeanFactoryAware,ApplicationContextAware,
        BeanPostProcessor,BeanDefinitionParser{
//        , InitializingBean {

    private AtomicInteger order = new AtomicInteger(0);

    @Resource
    private InjectFieldBean injectFieldBean;

//    @Override
//    public void setBeanName(String name) {
//        System.out.println("====== " + order.getAndIncrement()
//                + "========" + "setting beanName:" + name + "\n");
//    }

//    @Override
//    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
//        System.out.println("====== " + order.getAndIncrement()
//                + "========" + "setting bean factory:" + beanFactory.toString() + "\n");
//    }

//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        System.out.println("====== " + order.getAndIncrement()
//                + "========" + "setting applicationContext: " + applicationContext.toString() + "\n");
//    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("====== " + order.getAndIncrement()
                + "========" + "post before ,beanName:" + beanName + "\n");
        return bean;
    }


    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("111111111111111");
        System.out.println("====== " + order.getAndIncrement()
                + "========" + "post after ,beanName:" + beanName + "\n");
        return bean;
    }

//    @Override
//    public void afterPropertiesSet() throws Exception {
//        System.out.println("====== " + order.getAndIncrement()
//                + "========" + "invoke afterPropertiesSet" + "\n");
//    }

    public void init() {
        System.out.println("====== " + order.getAndIncrement()
                + "========" + "init method" + "\n");
    }

    public void setInjectFieldBean(InjectFieldBean injectFieldBean) {
        System.out.println("====== " + order.getAndIncrement()
                + "========" + "initializing injectFieldBean" + "\n");
        this.injectFieldBean = injectFieldBean;
    }

    @Override
    public BeanDefinition parse(Element element, ParserContext parserContext) {
        System.out.println("====== " + order.getAndIncrement()
                + "========" +"oooooooooooooooooooo");
        return null;
    }
}
