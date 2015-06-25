package com.jiangbo.proxy;

/**
 * <p>
 * <p> Date: 14-4-18 Time: 下午4:13 </p>
 *
 * @author jiangbo.wjb
 */
public class RealSource implements Source {
    @Override
    public void test() {
        System.out.println("11111111");
    }
}
