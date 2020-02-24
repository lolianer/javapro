package com.neuedu.test2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        /*try {
            Socket s = new Socket("127.0.0.1",9999);
            System.out.println("客户端已连接");
            Scanner scanner = new Scanner(System.in);
            OutputStream os = s.getOutputStream();
            PrintWriter ps = new PrintWriter(os);
            while (true){
                String str = scanner.nextLine();

                ps.println(str);
                ps.flush();
                if (str.equals("exit")){
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/


        try {
            ServerSocket server = new ServerSocket(9999);
            Socket socket = server.accept();
            InputStream is = socket.getInputStream();
            byte[] b = new byte[1024];
            int a = is.read(b);
            String s = new String(b,0,a);
            OutputStream os = socket.getOutputStream();
            StringBuilder builder = new StringBuilder();
            builder.append("HTTP/1.1 200 OK\n");
            builder.append("Content-type: text/html\n");
            builder.append("\r\n");
            builder.append("<html>");
            builder.append("<head></head>");
            builder.append("<body><div style='width:100px; height:100px; background:#ff0000'></div></body>");
            builder.append("</html>");
            os.write(builder.toString().getBytes());
            os.flush();
            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
