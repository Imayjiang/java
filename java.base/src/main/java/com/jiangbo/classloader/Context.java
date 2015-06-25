package com.jiangbo.classloader;

/**
 * <p>
 * <p> Date: 14-4-15 Time: 下午3:45 </p>
 *
 * @author jiangbo.wjb
 */
public class Context {

    ClassLoader getLoader(){
        return this.getClass().getClassLoader();
    }
}
