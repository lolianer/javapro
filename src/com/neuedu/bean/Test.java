package com.neuedu.bean;

import java.io.*;

public class Test {
    public static void main(String[] args) {
        File file = new File("E:/a.txt");
        /*try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        //字节输出流
        /*OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file,true);
            String a = "11111111111";
            byte[] b = a.getBytes();
            outputStream.write(b);
            outputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (outputStream!=null)
                    outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
        //字节输入流
        /*InputStream is = null;
        try {
            is = new FileInputStream(file);
            byte[] b = new byte[10];
            int a = is.read(b);
            while (a!=-1){
                System.out.print(new String(b,0,a));
                a = is.read(b);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (is!=null)
                    is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
        //字符输入流
        /*Reader r = null;
        try {
            r = new FileReader(file);
            char[] a = new char[10];
            r.read(a);
            System.out.println(a);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (r != null)
                    r.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
        //BufferedReader
        /*Reader r = null;
        BufferedReader br = null;
        try {
            r = new FileReader(file);
            br = new BufferedReader(r);
            String a = br.readLine();
            System.out.println(a);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (br!=null)
                    br.close();
                if (r!=null)
                    r.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
        //字符输出流
        /*Writer w = null;
        try {
            w = new FileWriter(file,true);
            w.write("asdasd");
            w.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (w!=null)
                    w.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/

    }

}
