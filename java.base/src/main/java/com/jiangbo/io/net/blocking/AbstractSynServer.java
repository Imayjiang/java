package com.jiangbo.io.net.blocking;

import com.jiangbo.io.net.Server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * <p>
 * <p> Date: 2014/7/1 Time: 17:33 </p>
 *
 * @author jiangbo.wjb
 */
abstract class AbstractSynServer extends Server {

    private volatile boolean isOpen;
    protected ServerSocket server;

    AbstractSynServer(int port) {
        try {
            server = new ServerSocket();
            server.setReuseAddress(true);
            bind(new InetSocketAddress("127.0.0.1", port));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        isOpen = true;
    }

    @Override
    protected void bind(final SocketAddress address) throws IOException {
        if (server == null) {
            throw new IllegalStateException("server has not been initialized yet!");
        }
        if (server.isBound()) {
            throw new IllegalStateException("bound already!");
        }
        server.bind(address);
    }

    protected Socket accept() throws IOException {
        if (!isOpen()) {
            throw new IllegalStateException("not open yet!");
        }
        if (isClosed()) {
            throw new IllegalStateException("has been closed!");
        }
        return server.accept();
    }

    @Override
    public void shutdown() {
        try {
            if (server != null) {
                server.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean isOpen() {
        return this.isOpen;
    }

    @Override
    public boolean isClosed() {
        return server == null || !isOpen();
    }
}
