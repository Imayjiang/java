package com.jiangbo.io.net.blocking;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * <p>
 * <p> Date: 2014/7/1 Time: 17:44 </p>
 *
 * @author jiangbo.wjb
 */
public class Client implements Runnable {

    public static void main(String[] args) throws InterruptedException {
        int sCount = 0;
        int fCount = 0;
        for (int i = 0; i < 20; i++) {
            Thread t = new Thread(new Client());
            try {
                t.start();
                t.join();
                System.out.println("successful Count:" + (++sCount));
            } catch (Throwable e) {
                System.out.println("failed count:" + (++fCount));
                e.getCause().printStackTrace();
            }

        }

    }

    @Override
    public void run() {
        Socket connection = new Socket();
        try {
            connection.connect(new InetSocketAddress("127.0.0.1", 8080));
            connection.getOutputStream().write(new byte[]{1, 2, 3, 4});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
