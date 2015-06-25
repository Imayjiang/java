//package com.jiangbo.io.netty;
//
///**
//* <p>
//* <p> Date: 2014/6/25 Time: 20:12 </p>
//*
//* @author jiangbo.wjb
//*/
//public class FileServer {
//
//    private static final boolean SSL = System.getProperty("ssl") != null;
//
//    static final int PORT = Integer.parseInt(System.getProperty("port", SSL ? "8992" : "8023"));
//
//    public static void main(String[] args) {
//        // Configure SSL.
//        final SslContext sslCtx;
//        if (SSL) {
//            SelfSignedCertificate ssc = new SelfSignedCertificate();
//            sslCtx = SslContext.newServerContext(ssc.certificate(), ssc.privateKey());
//        } else {
//            sslCtx = null;
//        }
//
//        // Configure the server.
//        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
//        EventLoopGroup workerGroup = new NioEventLoopGroup();
//        try {
//            ServerBootstrap b = new ServerBootstrap();
//            b.group(bossGroup, workerGroup)
//                    .channel(NioServerSocketChannel.class)
//                    .option(ChannelOption.SO_BACKLOG, 100)
//                    .handler(new LoggingHandler(LogLevel.INFO))
//                    .childHandler(new ChannelInitializer<SocketChannel>() {
//                        @Override
//                        public void initChannel(SocketChannel ch) throws Exception {
//                            ChannelPipeline p = ch.pipeline();
//                            if (sslCtx != null) {
//                                p.addLast(sslCtx.newHandler(ch.alloc()));
//                            }
//                            p.addLast(
//                                    new StringEncoder(CharsetUtil.UTF_8),
//                                    new LineBasedFrameDecoder(8192),
//                                    new StringDecoder(CharsetUtil.UTF_8),
//                                    new ChunkedWriteHandler(),
//                                    new FileServerHandler());
//                        }
//                    });
//
//            // Start the server.
//            ChannelFuture f = b.bind(PORT).sync();
//
//            // Wait until the server socket is closed.
//            f.channel().closeFuture().sync();
//        } finally {
//            // Shut down all event loops to terminate all threads.
//            bossGroup.shutdownGracefully();
//            workerGroup.shutdownGracefully();
//        }
//
//    }
//}
