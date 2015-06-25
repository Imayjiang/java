package com.jiangbo.io.net;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/**
 * <p>
 * <p> Date: 2014/7/1 Time: 21:34 </p>
 *
 * @author jiangbo.wjb
 */
public class ServerBootstrap {

    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = new NioServer(8088);
        server.start();
//        Selector selector = Selector.open();
//        Thread.sleep(1000*60);
//        ServerSocketChannel channel = ServerSocketChannel.open();
//        channel.configureBlocking(false);
//        channel.bind(new InetSocketAddress(8888));
//        channel.register(selector, SelectionKey.OP_ACCEPT);
//        selector.select();
    }
}
