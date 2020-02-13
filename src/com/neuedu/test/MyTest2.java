package com.neuedu.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyTest2 {
    public static void main(String[] args) {
//        int sum = 0;
//        for(int i = 1; i <= 100; i++){
//            if(i%2==0){
//                sum = sum + i;
//            }
//        }
//        System.out.println(sum);









//        int m = 2;
//        int n = 10;
//        int a = 1;
//        for(int i = 1; i <= n; i++){
//            a = a*m;
//        }
//        System.out.println(a);



//        int a;
//        int b;
//        int c;
//        for(int i = 100; i <= 999; i++){
//            a = i/100;
//            b = (i - a * 100) / 10;
//            c = i % 10;
//            if(a*a*a+b*b*b+c*c*c == i){
//                System.out.println(i);
//            }
//        }
//        int a;
//        for (int i = 1; i < 10 ; i++){
//            for (int j = 0; j < 10; j++){
//                for (int k = 0; k < 10; k++){
//                    a = i*100+j*10+k;
//                    if (i*i*i+j*j*j+k*k*k == a){
//                        System.out.println(a);
//                    }
//                }
//            }
//        }



        //求最大公约数和最小公倍数
        /*Scanner s = new Scanner(System.in);
        System.out.println("输入a值");
        int a = s.nextInt();
        System.out.println("输入b值");
        int b = s.nextInt();
        int c = a>b?a:b;
        int f = a>b?b:a;
        int e = 0;
        int d = 0;
        for(int i = 1; i <= f ;i++){
            if(a%i==0&&b%i==0){
                d = i;
            }
        }
        for(int j = c; j <= a*b; j++){
            if(j % a == 0 && j % b == 0){
                e = j;
                break;
            }
        }
        System.out.println("最大公约数为"+d);
        System.out.println("最小公倍数为"+e);*/

        //输出斐波那契数列
        /*List<Integer> list = new ArrayList();
        list.add(1);
        list.add(1);
        for (int i = 0; i < 10; i++){
            int a = list.get(i);
            int b = list.get(i+1);
            list.add(a+b);
            System.out.println(list.get(i));
        }*/


        //一个球从100米高度落下，每次落地后反弹到原高度的一半，求第10次落地后 反弹多高
        /*List<Double> list = new ArrayList();
        list.add(100.0);
        for (int i = 0; i < 10; i++){
            Double a = list.get(i)/2;
            list.add(a);
            System.out.println(list.get(i));
        }
        System.out.println(list.get(10));*/


        //一个整数 加100后是一个完全平方数 再加168也是一个完全平方数 该数是多少
        /*int n = 0;
        while (true){
            if (Math.sqrt(n+100)%1.0==0&&Math.sqrt(n+168)%1.0==0){
                break;
            }
            n++;
        }
        System.out.println(n);*/


        //n个人围坐在一个圈子里 从1开始报数 报到3的时候 离开  最后剩下的是第几个人
        List<Integer> list = new ArrayList<>(100);
        for (int i = 0; i < 100; i++){
            list.add(i);
        }
        //第一种方法
        /*int j = 0;
        while (true){
            for (int i = 1; i <= 3; i++){
                if (i==3){
                    list.remove(j);
                }else {
                    j++;
                }
                if (j>=list.size())
                    j=0;
            }
            if (list.size() == 1)
                break;

        }

        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }*/
        //第二种方法
        int m = 1;
        while (true){
            for (int i = 1; i <= 3; i++){
                if (i!=3){
                    list.add(list.remove(0));
                }else {
                    list.remove(0);
                }
            }
            if (list.size() == 1)
                break;
        }
        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }


    }
}
