package com.jiangbo.io;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * <p>
 * <p> Date: 14-4-20 Time: 下午4:42 </p>
 *
 * @author jiangbo.wjb
 */
public class ByteIO {

    public static void main(String[] args) throws IOException {
        byteArrayInput();
    }

    private static void byteArrayInput() throws IOException {
        byte[] inputByteArr = "test string".getBytes();
        InputStream in = new ByteArrayInputStream(inputByteArr);
        //way one
        printByte(in);

        //way two
        //read into byte array in a time
        printByteArray(inputByteArr.length,in);
    }

    private static void printByte(final InputStream in) throws IOException {
        //read a byte in a time
        int readingByte = -2;// -1 end
        while (true) {
            readingByte = in.read();
            if (readingByte == -1) {
                break;
            }
            if(readingByte == -2) {
                throw new IllegalStateException("empty inputStream");
            }
            System.out.println(readingByte);
        }
    }

    private static void printByteArray(final int readSize,
                                       final InputStream in) throws IOException {
        final byte[] storeReadArr = new byte[readSize];
        int size = in.read(storeReadArr);
        if (size <= 0 || storeReadArr.length <= 0) {
            throw new IllegalStateException();
        }
        for (byte storeByte : storeReadArr) {
            System.out.println(storeByte);
        }
    }

}
