package com.neuedu.test;

public class MyArray {
    private int[] array;
    private int size;
    public MyArray(){
        size= 0;
        array = new int[10];
    }
    public void add(int n){
        if (size >= array.length){
            int[] newarray = new int[size+size/2];
            for (int i = 0; i < size; i++){
                newarray[i] = array[i];

            }
            array = newarray;
            System.out.println("扩容完成");
        }else {
            array[size] = n;
            size++;
        }
    }
    public int getSize(){
        return size;
    }
    public int get(int j){
        if (j<0||j >= size){
            System.out.println("输入索引错误");
        }else {
            return array[j];
        }
        return -1;
    }
}
