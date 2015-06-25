package com.jiangbo.io.net;

/**
 * <p>
 * <p> Date: 2014/6/30 Time: 18:53 </p>
 *
 * @author jiangbo.wjb
 */
public interface Pipeline {

    Pipeline next();

    void addLast(final Pipeline pipeline);

    void fireEvent();

}
