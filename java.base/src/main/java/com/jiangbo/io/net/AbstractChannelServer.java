package com.jiangbo.io.net;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/**
 * <p>
 * <p> Date: 2014/7/2 Time: 13:27 </p>
 *
 * @author jiangbo.wjb
 */
public abstract class AbstractChannelServer extends ChannelServer {

    private final ServerConfig config;

    private final ServerSocketChannel channel;

    private final Selector selector;

    public AbstractChannelServer(final int port) {
        this.config = new ServerConfig(port);
        try {
            this.selector = Selector.open();
            channel = ServerSocketChannel.open();
            channel.configureBlocking(false);
            channel.register(selector, SelectionKey.OP_ACCEPT);
            channel.bind(new InetSocketAddress(config.host, config.port));
        } catch (IOException e) {
            throw new RuntimeException("failed to start", e);
        }
    }

    protected Socket accept() {
        throw new RuntimeException("This method is not implemented yet!");
    }

    public Selector selector() {
        if (this.selector == null) {
            throw new IllegalStateException("not initialized yet!");
        }
        return this.selector;
    }

    public ServerConfig config() {
        return this.config;
    }

    public ServerSocketChannel channel() {
        return channel;
    }

    static class ServerConfig {

        private final String host;

        private final int port;

        ServerConfig(int port) {
            this("127.0.0.1", port);
        }

        ServerConfig(String host, int port) {
            this.host = host;
            this.port = port;
        }

    }
}


