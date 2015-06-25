package com.spring;

import com.taobao.common.ip.impl.LocalIpManager;

/**
 * <p>
 * </p>
 * <p> Date: 2014/12/9 Time: 11:42 </p>
 *
 * @author jiangbo.wjb
 */
public class BeanB {

    private static final LocalIpManager IP_MANAGER = new LocalIpManager();
    {
        IP_MANAGER.init();
    }

}
