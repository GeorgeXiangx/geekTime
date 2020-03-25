package com.learn.test.io;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * Created by XJH on 2020/2/26.
 *
 * @Description:
 */
public class AsyncIOServer extends Thread{
    @Override
    public void run() {
        try {
            AsynchronousServerSocketChannel serverSocket = AsynchronousServerSocketChannel.open().bind(
                    new InetSocketAddress(InetAddress.getLocalHost(), 8888));
            serverSocket.accept(serverSocket, new CompletionHandler<AsynchronousSocketChannel, AsynchronousServerSocketChannel>() {
                @Override
                public void completed(AsynchronousSocketChannel socketChannel, AsynchronousServerSocketChannel attachment) {
                    serverSocket.accept(serverSocket, this);
//                    sayHelloWorld(socketChannel, Charset.defaultCharset().encode("Hello World"));
                }

                @Override
                public void failed(Throwable exc, AsynchronousServerSocketChannel attachment) {

                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
