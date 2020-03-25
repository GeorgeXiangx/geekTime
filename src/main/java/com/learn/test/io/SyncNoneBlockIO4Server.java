package com.learn.test.io;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by XJH on 2020/2/26.
 *
 * @Description:用nio(同步非阻塞)实现
 */
public class SyncNoneBlockIO4Server extends Thread{

    @Override
    public void run() {
        // 首先，通过 Selector.open() 创建一个 Selector，作为类似调度员的角色
        try (Selector selector = Selector.open();
             ServerSocketChannel serverSocket = ServerSocketChannel.open()) {
            serverSocket.bind(new InetSocketAddress(InetAddress.getLocalHost(), 8888));
            serverSocket.configureBlocking(false);

            // 注册到Selector,说明关注点
            serverSocket.register(selector, SelectionKey.OP_ACCEPT);
            while (true) {
                // Selector 阻塞在 select 操作，当有 Channel 发生接入请求，就会被唤醒。
                selector.select();// 阻塞等待就绪的Channel，关键点之一
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();

                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    sayHelloWorld((ServerSocketChannel)key.channel());
                    iterator.remove();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sayHelloWorld(ServerSocketChannel server) {
        try (SocketChannel client = server.accept()) {
            client.write(Charset.defaultCharset().encode("Hello World"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
