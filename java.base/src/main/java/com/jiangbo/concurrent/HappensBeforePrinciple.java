package com.jiangbo.concurrent;

/**
 * <p>
 * happensBefore是针对JMM action的principle。
 * 该原则主要阐述action A跟action B的偏序关系。假设A先于B发生，则A产生的
 * 所有影响（如对变量的init、update）都对B可见。
 *
 * <p> Date: 14-4-26 Time: 下午3:58 </p>
 *
 * @author jiangbo.wjb
 */
public class HappensBeforePrinciple {

    public static void main(String[] args) throws Exception {
    }

}
