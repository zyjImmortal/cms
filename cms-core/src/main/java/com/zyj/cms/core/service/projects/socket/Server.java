package com.zyj.cms.core.service.projects.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author zhouyajun
 * @date 2019/5/6
 */
public class Server {
    private ServerSocket serverSocket;
    private Socket socket;

    public Server(){
        try {
            serverSocket = new ServerSocket(7878);
            socket = serverSocket.accept();

            InputStreamReader reader = new InputStreamReader(socket.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(reader);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
