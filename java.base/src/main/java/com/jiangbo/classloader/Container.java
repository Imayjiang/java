package com.jiangbo.classloader;

/**
 * <p>
 * <p> Date: 14-4-15 Time: 下午3:44 </p>
 *
 * @author jiangbo.wjb
 */
public interface Container extends Lifecycle {

    ClassLoader getClassLoader();

    Context getContext();

    Component[] getComponents();

    void addComponent(final Component component);

}
