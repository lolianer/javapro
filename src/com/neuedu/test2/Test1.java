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
            //讲s接收到的成为字节流
            InputStream is = s.getInputStream();
            //改为字符流
            InputStreamReader isr = new InputStreamReader(is);
            //改为Buffer字符流，可以一行一行读
            BufferedReader br = new BufferedReader(isr);
            while (true){
                String str = br.readLine();
                if (str.equals("exit")){
                    break;
                }
                System.out.println("客户端输出的内容"+str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
