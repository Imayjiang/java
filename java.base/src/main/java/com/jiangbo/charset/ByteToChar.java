package com.jiangbo.charset;

import java.io.UnsupportedEncodingException;

/**
 * <p>
 * <p> Date: 14-3-5 Time: 下午11:12 </p>
 *
 * @author jiangbo.wjb
 */
public class ByteToChar {


    public static void main(String[] args) throws UnsupportedEncodingException {
        String s = "abs";//这是测试小程序";

        byte[] bytes = s.getBytes();
        System.out.println("byte array start===============");
        for (int i = 0; i < bytes.length; i++) {
            System.out.println(bytes[i]);
        }
        System.out.println("byte array end===============");

        byte[] bytes1 = s.getBytes("ISO-8859-1");
        System.out.println("byte array start========= ======");
        for (int j = 0; j < bytes1.length; j++) {
            System.out.println(bytes1[j]);
        }
        System.out.println("byte array end===============");

    }
}
