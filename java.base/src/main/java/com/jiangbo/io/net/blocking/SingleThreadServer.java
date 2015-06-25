package com.jiangbo.io.net.blocking;

import com.jiangbo.io.net.Server;

import java.io.IOException;
import java.net.Socket;

/**
 * <p>
 * <p> Date: 2014/7/16 Time: 14:42 </p>
 *
 * @author jiangbo.wjb
 */
public class SingleThreadServer
        extends AbstractSynServer {

    public SingleThreadServer() {
        this(8080);
    }

    public SingleThreadServer(final int port) {
        super(port);
    }

    @Override
    public void start() {
        if (!server.isBound()) {
            throw new IllegalStateException("not bound yet!");
        }
        if (server.isClosed()) {
            throw new IllegalStateException("has been closed!");
        }
        Socket client;
        int connCount = 0;
        for (; ; ) {
            try {
                Thread.sleep(1000 * 20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            try {
//                client = accept();
                connCount++;
//                System.out.println("接入数：" + connCount + client.toString());
//            } catch (IOException e) {
//                throw new RuntimeException("i can do nothing!", e);
//            }
        }
    }

    public static void main(String[] args) {
        Server server = new SingleThreadServer();
        try {
            server.start();
        } catch (Throwable t) {
            System.err.print(t.getCause().getMessage());
            if (server.isOpen() && !server.isClosed()) {
                server.shutdown();
            }
        }

    }
}
