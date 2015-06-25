package com.jiangbo.io.net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * <p>
 * server生命周期：
 * 1)bind a special port
 * <p/>
 * 2)listen for incoming connection
 * <p/>
 * 3)accept incoming connection
 * <p/>
 * 4)close connection
 * </p>
 * <p/>
 * <p> Date: 2014/7/16 Time: 14:23 </p>
 *
 * @author jiangbo.wjb
 */
public abstract class Server {

    protected abstract void bind(final SocketAddress address) throws IOException;

    public abstract void start();

    public abstract void shutdown();

    public abstract boolean isOpen();

    public abstract boolean isClosed();


}
