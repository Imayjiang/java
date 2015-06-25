package com.jiangbo.study;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;


/**
 * Hello world!
 */
public class FileServer {

    private int port;

    FileServer(final int port) {
        this.port = port;
    }

    public void startup() throws InterruptedException {
        //open selector and bind executor(with fixed count task queue) to selector
                /**
                 * boss has only one executor while worker has [cpu process*2]
                 */
                EventLoopGroup bossGroup = new NioEventLoopGroup(1);
                EventLoopGroup workerGroup = new NioEventLoopGroup();
                try {
                    ServerBootstrap serverBootstrap = new ServerBootstrap();
                    serverBootstrap.group(bossGroup, workerGroup)
                            //初始化channel，但没注册到selector上
                            //PS：这里对设计有一点不解，option、handler跟channel感觉是有先后依赖的关系，但是从上层来说，仅仅是set一下
                            .channel(NioServerSocketChannel.class)
                            .option(ChannelOption.SO_BACKLOG, 100)
                            .handler(new LoggingHandler(LogLevel.INFO))
                            .childHandler(new ChannelInitializer<SocketChannel>() {
                                @Override
                                public void initChannel(SocketChannel ch) throws Exception {
                                    final ChannelPipeline p = ch.pipeline();
                                    p.addLast(
                                            new DiscardHandler());
                                }
                            });

                    // Start the server.
                    ChannelFuture future = serverBootstrap.bind(this.port).sync();

                    // Wait until the server socket is closed.
                    future.channel().closeFuture().sync();
                } finally {
                    // Shut down all event loops to terminate all threads.
                    bossGroup.shutdownGracefully();
                    workerGroup.shutdownGracefully();
                }
    }

    public static void main(String[] args) throws InterruptedException {
        FileServer fileServer = new FileServer(8888);
        fileServer.startup();

    }

    private class DiscardHandler extends ChannelHandlerAdapter {

        @Override
        public void channelRead(final ChannelHandlerContext ctx, final Object msg) throws Exception {
            super.channelRead(ctx, msg);
            ((ByteBuf) msg).release();
        }


    }
}
