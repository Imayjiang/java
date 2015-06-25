package com.jiangbo.numerictype;

import java.util.Arrays;

/**
 * <p>
 *     移位操作
 *   左移的数学意义：十进制的数字变成了它乘以2^n,n是移动的位数。
 *   右移的数学意义:
 *   如，左移两位，则表示该数值*2^2
 * </p>
 * <p> Date: 2014/8/6 Time: 21:19 </p>
 *
 * @author jiangbo.wjb
 */
public class Codec {

    public static byte[] fromInt(int value) {
        byte[] buffer = new byte[4];
        for (int i = 0; i < 4; i++) {
            System.out.println(value >> (8 * i));
            buffer[i] = (byte) (value >> (8 * i));
        }
        return buffer;
    }

    public static void main(String[] args) {
        System.out.println(10<<2);
        System.out.println(Arrays.toString(fromInt(10)));
    }
}
