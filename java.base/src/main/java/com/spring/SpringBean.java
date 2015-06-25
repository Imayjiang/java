package com.spring;

import com.container.BeanFactory;

/**
 * <p>
 * </p>
 * <p> Date: 2014/11/25 Time: 12:24 </p>
 *
 * @author jiangbo.wjb
 */
public abstract class SpringBean {

    protected SpringBean() {
        BeanFactoryHolder.getInstance().bean(this);
    }

}
