package com.neuedu.bean;

import java.io.*;

//文件复制    第二次
public class Test5 {
    public static void main(String[] args) {
        copy();
    }
    public static void copy(){
        File from =new File("E:\\Neuedu\\0214\\1 虚拟网络配置.wmv");
        File path = new File("e:/a");
        File to = new File("e:/a/"+from.getName());
        if (!path.exists()||!path.isDirectory())
            path.mkdirs();
        byte[] b = new byte[1024];
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(from);
            os = new FileOutputStream(to);
            int a = is.read(b);
            while (a != -1){
                os.write(b,0,a);
                os.flush();
                a = is.read(b);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (os != null)
                    os.close();
                if (is != null)
                    is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
