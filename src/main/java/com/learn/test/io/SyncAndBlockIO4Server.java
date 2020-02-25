package com.learn.test.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by XJH on 2020/2/25.
 *
 * @Description:java.io和java.net同步阻塞实现服务器(同时服务多个客户端)
 */
public class SyncAndBlockIO4Server extends Thread{
    private ServerSocket serverSocket;

    public int getPort(){
        return serverSocket.getLocalPort();
    }

    @Override
    public void run() {
        try {
            // 启一个server
            serverSocket = new ServerSocket(0);
            while (true) {
                // 只要server监听到了客户端连接
                Socket socket = serverSocket.accept();
                // 另起一个RequestHandler来处理
                RequestHandler requestHandler = new RequestHandler(socket);
                requestHandler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        SyncAndBlockIO4Server server = new SyncAndBlockIO4Server();
        server.start();

        try (Socket client = new Socket(InetAddress.getLocalHost(), server.getPort())) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            bufferedReader.lines().forEach(s -> System.out.println(s));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// 简化实现，不做读取，直接发送字符串
class RequestHandler extends Thread {
    private Socket socket;

    public RequestHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try (PrintWriter out = new PrintWriter(socket.getOutputStream())) {
            out.println("Hell World");
            out.flush();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}