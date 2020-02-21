package com.neuedu.test2;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("127.0.0.1",9999);
            System.out.println("客户端已连接");
            Scanner scanner = new Scanner(System.in);
            OutputStream os = s.getOutputStream();
            PrintStream ps = new PrintStream(os);
            while (true){
                String str = scanner.nextLine();
                ps.println(str);
                ps.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
