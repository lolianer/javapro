package com.neuedu.bean;

import com.neuedu.test.MyArray;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Test4 {
    public static int a = 0;
    public static void main(String[] args) {
        /*MyThread t1 = new MyThread();
        Thread t = new Thread(t1);
        t.start();*/
        /*MyAdd add = new MyAdd();
        int a = method(1, 2, (c,b)-> {
            return c+b;
        });
        System.out.println(a);*/
        /*Thread t1 = new Thread(()->{
            for (int i = 0; i < 100; i++){
                System.out.println("sda");
            }
        });*/
       /* MyThead2 t = new MyThead2();
        Thread t2 = new Thread(t);
        Thread t1 = new Thread(t);
        t2.start();
        t1.start();*/
        Object o = new Object();
        Semaphore s = new Semaphore(1);
        CountDownLatch c = new CountDownLatch(5000);
        for (int i= 0; i < 5000; i++){
            Thread t = new Thread(()->{
                try {
                    s.acquire();
                    a++;
                    c.countDown();
                    s.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            });
            t.start();
        }
        try {
            c.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(a);




    }
    /*public static int method(int a, int b,MyInterface myInterface){
        return myInterface.method(a,b);
    }*/

}
