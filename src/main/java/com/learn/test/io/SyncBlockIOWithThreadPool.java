package com.learn.test.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by XJH on 2020/2/26.
 *
 * @Description:
 */
public class SyncBlockIOWithThreadPool extends Thread{
    private ServerSocket serverSocket;
    private ExecutorService executorService;

    public int getPort(){
        return serverSocket.getLocalPort();
    }

    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(0);
            // 初始化线程池
            executorService = Executors.newFixedThreadPool(10);

            while (true) {
                Socket socket = serverSocket.accept();
                RequestHandler4ThreadPool requestHandler = new RequestHandler4ThreadPool(socket);
                executorService.execute(requestHandler);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SyncBlockIOWithThreadPool server = new SyncBlockIOWithThreadPool();
        server.start();

        // 利用 Socket 模拟了一个简单的客户端，只进行连接、读取、打印。
        try (Socket client = new Socket(InetAddress.getLocalHost(), server.getPort())) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            bufferedReader.lines().forEach(s -> System.out.println(s));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class RequestHandler4ThreadPool extends Thread {
    private Socket socket;

    public RequestHandler4ThreadPool(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (PrintWriter out = new PrintWriter(socket.getOutputStream())) {
            System.out.println("Hello World");
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
