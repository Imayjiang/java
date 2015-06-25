//package com.jiangbo.io;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.RandomAccessFile;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.nio.channels.Channels;
//import java.nio.channels.FileChannel;
//import java.nio.channels.ServerSocketChannel;
//
//
//import java.io.IOException;
//import java.net.InetSocketAddress;
//import java.nio.ByteBuffer;
//import java.nio.channels.SelectionKey;
//import java.nio.channels.Selector;
//import java.nio.channels.SocketChannel;
//import java.util.Iterator;
//import java.util.Set;
//
///**
// * <p>
// * <p> Date: 2014/6/25 Time: 15:16 </p>
// *
// * @author jiangbo.wjb
// */
//public class AynIOSample {
//
//    /**
//     * @param args
//     * @throws IOException
//     */
//    public static void main(String[] args) throws IOException {
//        // TODO Auto-generated method stub
//        int port = 8888;
//        NIOServer server = new NIOServer(port);
//        server.listen();
//    }
//
//
//    public static class NIOServer {
//
//        /*标识数字*/
//        private int flag = 0;
//        /*缓冲区大小*/
//        private int BLOCK = 4096;
//        /*接受数据缓冲区*/
//        private ByteBuffer sendbuffer = ByteBuffer.allocate(BLOCK);
//        /*发送数据缓冲区*/
//        private ByteBuffer receivebuffer = ByteBuffer.allocate(BLOCK);
//        private Selector selector;
//
//        public NIOServer(int port) throws IOException {
//            // 打开服务器套接字通道
//            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
//            // 服务器配置为非阻塞
//            serverSocketChannel.configureBlocking(false);
//            // 检索与此通道关联的服务器套接字
//            ServerSocket serverSocket = serverSocketChannel.socket();
//            // 进行服务的绑定
//            serverSocket.bind(new InetSocketAddress(port));
//            // 通过open()方法找到Selector
//            selector = Selector.open();
//            // 注册到selector，等待连接
//            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
//            System.out.println("Server Start----8888:");
//        }
//
//
//        // 监听
//        private void listen() throws IOException {
//            while (true) {
//                // 选择一组键，并且相应的通道已经打开
//                selector.select();
//                // 返回此选择器的已选择键集。
//                Set<SelectionKey> selectionKeys = selector.selectedKeys();
//                Iterator<SelectionKey> iterator = selectionKeys.iterator();
//                while (iterator.hasNext()) {
//                    SelectionKey selectionKey = iterator.next();
//                    iterator.remove();
//                    handleKey(selectionKey);
//                }
//            }
//        }
//
//        // 处理请求
//        private void handleKey(SelectionKey selectionKey) throws IOException {
//            // 接受请求
//            ServerSocketChannel server = null;
//            SocketChannel client = null;
//            String receiveText;
//            String sendText;
//            int count = 0;
//            // 测试此键的通道是否已准备好接受新的套接字连接。
//            if (selectionKey.isAcceptable()) {
//                // 返回为之创建此键的通道。
//                server = (ServerSocketChannel) selectionKey.channel();
//                // 接受到此通道套接字的连接。
//                // 此方法返回的套接字通道（如果有）将处于阻塞模式。
//                client = server.accept();
//                // 配置为非阻塞
//                client.configureBlocking(false);
//                // 注册到selector，等待连接
//                client.register(selector, SelectionKey.OP_READ);
//            } else if (selectionKey.isReadable()) {
//                // 返回为之创建此键的通道。
//                client = (SocketChannel) selectionKey.channel();
//                //将缓冲区清空以备下次读取
//                receivebuffer.clear();
//                //读取服务器发送来的数据到缓冲区中
//                count = client.read(receivebuffer);
//                if (count > 0) {
//                    receiveText = new String(receivebuffer.array(), 0, count);
//                    System.out.println("服务器端接受客户端数据--:" + receiveText);
//                    client.register(selector, SelectionKey.OP_WRITE);
//                }
//            } else if (selectionKey.isWritable()) {
//                //将缓冲区清空以备下次写入
//                sendbuffer.clear();
//                // 返回为之创建此键的通道。
//                client = (SocketChannel) selectionKey.channel();
//                sendText = "message from server--" + flag++;
//                //向缓冲区中输入数据
//                sendbuffer.put(sendText.getBytes());
//                //将缓冲区各标志复位,因为向里面put了数据标志被改变要想从中读取数据发向服务器,就要复位
//                sendbuffer.flip();
//                //输出到通道
//                client.write(sendbuffer);
//                System.out.println("服务器端向客户端发送数据--：" + sendText);
//                client.register(selector, SelectionKey.OP_READ);
//            }
//        }
//
//    }
//
//
//    public static class NIOClient {
//
//        /*服务器端地址*/
//        private final static InetSocketAddress SERVER_ADDRESS = new InetSocketAddress(
//                "localhost", 1111);
//
//        public void conn() throws IOException {
//            int flag = 0;
//            /*缓冲区大小*/
//            final int BLOCK = 4096;
//                    /*接受数据缓冲区*/
//            ByteBuffer sendbuffer = ByteBuffer.allocate(BLOCK);
//                    /*发送数据缓冲区*/
//            ByteBuffer receivebuffer = ByteBuffer.allocate(BLOCK);
//            // TODO Auto-generated method stub
//            // 打开socket通道
//            SocketChannel socketChannel = SocketChannel.open();
//            // 设置为非阻塞方式
//            socketChannel.configureBlocking(false);
//            // 打开选择器
//            Selector selector = Selector.open();
//            // 注册连接服务端socket动作
//            socketChannel.register(selector, SelectionKey.OP_CONNECT);
//            // 连接
//            socketChannel.connect(SERVER_ADDRESS);
//            // 分配缓冲区大小内存
//
//            Set<SelectionKey> selectionKeys;
//            Iterator<SelectionKey> iterator;
//            SelectionKey selectionKey;
//            SocketChannel client;
//            String receiveText;
//            String sendText;
//            int count = 0;
//
//            while (true) {
//                //选择一组键，其相应的通道已为 I/O 操作准备就绪。
//                //此方法执行处于阻塞模式的选择操作。
//                selector.select();
//                //返回此选择器的已选择键集。
//                selectionKeys = selector.selectedKeys();
//                //System.out.println(selectionKeys.size());
//                iterator = selectionKeys.iterator();
//                while (iterator.hasNext()) {
//                    selectionKey = iterator.next();
//                    if (selectionKey.isConnectable()) {
//                        System.out.println("client connect");
//                        client = (SocketChannel) selectionKey.channel();
//                        // 判断此通道上是否正在进行连接操作。
//                        // 完成套接字通道的连接过程。
//                        if (client.isConnectionPending()) {
//                            client.finishConnect();
//                             System.out.println("完成连接!");
//                            sendbuffer.clear();
//                            sendbuffer.put("Hello,Server".getBytes());
//                            sendbuffer.flip();
//                            client.write(sendbuffer);
//                        }
//                        client.register(selector, SelectionKey.OP_READ);
//                    } else if (selectionKey.isReadable()) {
//                        client = (SocketChannel) selectionKey.channel();
//                        //将缓冲区清空以备下次读取
//                        receivebuffer.clear();
//                        //读取服务器发送来的数据到缓冲区中
//                        count = client.read(receivebuffer);
//                        if (count > 0) {
//                            receiveText = new String(receivebuffer.array(), 0, count);
//                            System.out.println("客户端接受服务器端数据--:" + receiveText);
//                            client.register(selector, SelectionKey.OP_WRITE);
//                        }
//
//                    } else if (selectionKey.isWritable()) {
//                        sendbuffer.clear();
//                        client = (SocketChannel) selectionKey.channel();
//                        sendText = "message from client--" + (flag++);
//                        sendbuffer.put(sendText.getBytes());
//                        //将缓冲区各标志复位,因为向里面put了数据标志被改变要想从中读取数据发向服务器,就要复位
//                        sendbuffer.flip();
//                        client.write(sendbuffer);
//                        System.out.println("客户端向服务器端发送数据--：" + sendText);
//                        client.register(selector, SelectionKey.OP_READ);
//                    }
//                }
//                selectionKeys.clear();
//            }
//        }
//    }
//
//    void opFile() throws FileNotFoundException {
//        RandomAccessFile file = new RandomAccessFile("","ws");
//        FileChannel fileChannel = file.getChannel();
//        ByteBuffer byteBuffer = B;
//    }
//
//
//}
