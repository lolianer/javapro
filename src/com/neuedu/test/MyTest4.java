package com.neuedu.test;
//this怎么用的？
//构造方法只需要public来修饰
public class MyTest4 {
    public static void main(String[] args) {
        MyArray array = new MyArray();
        for (int i = 0; i < 20; i++){
            array.add(i);
        }
        for (int j = 0; j < array.getSize(); j++){
            System.out.println(array.get(j));
        }
    }
}
