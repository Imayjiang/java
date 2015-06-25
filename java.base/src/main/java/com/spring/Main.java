package com.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.DecimalFormat;

/**
 * <p>
 * </p>
 * Date:2015/1/21  Time:17:54
 *
 * @author:jiangbo.wjb
 */
public class Main {

    public static void main(String[] args) {

        Double percent = Double.valueOf("1199.9829999")/100;
//        if (percent >= 100) {
//            throw new IllegalArgumentException("expect less than 100,actual:" + percent);
//        }
        DecimalFormat df = new DecimalFormat("#0.0000");
        System.out.println(String.valueOf((df.format(percent))));
    }
}
