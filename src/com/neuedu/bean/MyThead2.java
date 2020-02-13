package com.neuedu.bean;

public class MyThead2 implements Runnable{
    private int cound = 50;
    Object a = new Object();
    @Override
    public void run() {
        add();
        /*while (cound > 0){
            synchronized (a){
                System.out.println(Thread.currentThread().getName()+"------"+cound);
                cound--;
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
    }
    public synchronized void add(){
        for (int i = 0; i < 100; i++){
            System.out.println(Thread.currentThread().getName()+i);
        }
    }
}
