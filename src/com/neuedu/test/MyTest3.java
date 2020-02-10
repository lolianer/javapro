package com.neuedu.test;

import java.util.Scanner;

public class MyTest3 {
    public static void main(String[] args) {
        //冒泡排序
        /*int[] array = {5,4,3,2,1};
        for (int i = 0; i < array.length-1; i++){
            int flag = 0;
            for (int j = 0; j <array.length-(i+1); j++){
                if (array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    flag = 1;
                }
            }
            if (flag == 0){
                break;
            }
        }
        for (int k : array){
            System.out.println(k);
        }*/


        //选择排序
        /*for (int i = 0; i < array.length-1; i++){
            for (int j = i+1; j <array.length; j++){
                if (array[i] > array[j]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        for (int k : array){
            System.out.print(k);
        }*/
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++){
            array[i] = 100-i;
        }


        Scanner s = new Scanner(System.in);
        System.out.println("请输入一个数：");
        int n = s.nextInt();
        int index = reasch(array, n);
        System.out.println(index);


    }
    public static int reasch (int array[],int n){
        int min = 0;
        int max = array.length-1;
        int mid;
        int count = 0;
        while(min <= max){
            count++;
            mid = (max+min)/2;
            if (array[mid] == n){
                System.out.println("查找了"+count+"次");
                return mid;
            }else if (array[mid] < n){
                max = mid-1;
            }else {
                min = mid+1;
            }
        }
        return -1;
    }
}
