package com.neuedu.bean;

public class MyThead1 extends Thread{
    @Override
    public void run() {
        int a = 0;
        for (int i = 0; i < 50; i++){
            System.out.println(Thread.currentThread().getName()+"------"+i);
            a++;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
