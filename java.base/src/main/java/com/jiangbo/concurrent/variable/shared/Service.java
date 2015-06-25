package com.jiangbo.concurrent.variable.shared;

/**
 * <p>
 * <p> Date: 14-5-10 Time: 下午6:13 </p>
 *
 * @author jiangbo.wjb
 */
public interface Service {

    public void service(Request req) throws InterruptedException;

}
