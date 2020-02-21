package com.neuedu.test2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Test1 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(9999);
            //该方法为阻塞 等待客户端连接成为一个套接字
            Socket s = server.accept();
            System.out.println("客户端已连接");
            InputStream is = s.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            while (true){
                String str = br.readLine();
                System.out.println("客户端输出的内容"+str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
