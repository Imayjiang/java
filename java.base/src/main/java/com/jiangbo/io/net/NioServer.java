package com.jiangbo.io.net;


import com.jiangbo.concurrent.Executors;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;

/**
 * <p>
 * <p> Date: 2014/6/30 Time: 13:15 </p>
 *
 * @author jiangbo.wjb
 */
public class NioServer extends AbstractChannelServer {

    public NioServer(final int port) {
        super(port);
    }

    @Override
    public ChannelServer channel(final Channel channel) {
        throw new UnsupportedOperationException("not support yet!");
    }

    @Override
    public ChannelServer pipeline(final Pipeline pipeline) {
        throw new RuntimeException("This method is not implemented yet!");
    }

    @Override
    public void bind(final SocketAddress address) throws IOException {
        throw new RuntimeException("This method is not implemented yet!");
    }

    @Override
    public void start() {
        for (; ; ) {
            try {
                int selectedCount = selector().select();
                if(selectedCount == 0) {
                    continue;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            final Set<SelectionKey> selected = selector().selectedKeys();
            Iterator<SelectionKey> iterator = selected.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                handle(key);
                iterator.remove();
            }
            selected.clear();
        }
    }


    private void handle(final SelectionKey key) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(2014);
        if (key.isValid() && key.isAcceptable()) {
            try {
                final SocketChannel clientChannel = channel().accept();
                clientChannel.read(byteBuffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void shutdown() {
        throw new RuntimeException("This method is not implemented yet!");
    }

    @Override
    public boolean isOpen() {
        throw new RuntimeException("This method is not implemented yet!");
    }

    @Override
    public boolean isClosed() {
        throw new RuntimeException("This method is not implemented yet!");
    }
}
