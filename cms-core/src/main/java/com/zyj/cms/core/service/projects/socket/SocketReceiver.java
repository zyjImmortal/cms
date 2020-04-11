package com.zyj.cms.core.service.projects.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: zhouyajun
 * @date: 2020-02-07
 */
public class SocketReceiver {
    public static final int corePoolSize = 5;
    public static final int maxPoolSize = 5;
    public static final int blockingQueue = 50;

    public void init() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maxPoolSize,
                0L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(blockingQueue));
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(Constants.PORT);
            System.out.println("服务已启动:" + serverSocket.getLocalSocketAddress().toString());
            //接收信息并传递给线程池
            while (true) {
                Socket socket = serverSocket.accept();
                executor.submit(new Handler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (serverSocket != null){
                try {
                    serverSocket.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        SocketReceiver receiver = new SocketReceiver();
        receiver.init();
    }
}
