package com.neuedu.bean;

import java.io.*;

public class Test2 {
    public static void main(String[] args) {
        File from = new File("E:\\qq音乐\\QQMusic_YQQMusicHallList.exe");
        File parent = new File("E:/a");
        File to = new File("E:/a/QQMusic_YQQMusicHallList.exe");
        if (!parent.exists())
            parent.mkdir();
        if (!to.exists()) {
            try {
                to.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(from);
            os = new FileOutputStream(to);
            byte[] b = new byte[1024];
            int a = is.read(b);
            while (a!=-1){
                os.write(b,0,a);
                a = is.read(b);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
