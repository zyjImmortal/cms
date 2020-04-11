package com.zyj.cms.core.service.projects.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author: zhouyajun
 * @date: 2020-02-07
 */
public class Handler implements Runnable{
    private Socket socket;

    public Handler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream in = socket.getInputStream();
            int count = 0;
            while (count == 0) {
                count = in.available();
            }
            byte[] b = new byte[count];
            in.read(b);
            String message = new String(b);
            System.out.println(" receive request: " + socket.getInetAddress() + " " + message);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 向客户端发送确认消息
            // 定义输出流outer
            OutputStream outer = socket.getOutputStream();
            //将客户端发送的信息加上确认信息ok
            String response = message + " is OK";
            //将输入信息保存到b_out中
            byte[] b_out = response.getBytes();
            //写入输入流
            outer.write(b_out);
            //推送输入流到客户端
            outer.flush();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
