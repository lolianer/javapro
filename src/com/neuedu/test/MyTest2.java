package com.neuedu.test;

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




        Scanner s = new Scanner(System.in);
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
        System.out.println("最小公倍数为"+e);
    }
}
