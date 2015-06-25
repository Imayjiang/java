package com.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <p>
 * </p>
 * <p> Date: 2014/11/25 Time: 11:55 </p>
 *
 * @author jiangbo.wjb
 */
public class BizBean extends SpringBean {

    public PersistenBean getPersistenBean() {
        return persistenBean;
    }


    public void setPersistenBean(final PersistenBean persistenBean) {
        this.persistenBean = persistenBean;
    }

    private PersistenBean persistenBean;

    public BizBean() {
        super();
    }

    public static void main(String[] args) {
        final ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("classpath:spring/application.xml");
        BeanA beanA =(BeanA) applicationContext.getBean("beanA");
        BeanB beanB = (BeanB) applicationContext.getBean("beanB");

//        BizBean bean = new BizBean();
//        System.out.println(bean);
//        System.out.println(bean.getPersistenBean());
    }


}
