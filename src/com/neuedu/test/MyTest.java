package com.neuedu.test;
/**     静态方法：不需要创建对象就可直接使用
 * 在创建方法时，需要使用static修饰
 * 调用静态方法时，直接 类名.方法 就可以
 * 构造方法：类下的一种方法，该方法与类名相同，用处为创造对象
 * 重载，重写区别：
 *     重载是一个类的事。重写是具有父子关系两个类的事
 *     重载是方法名相同，参数列表不同，为了更多形式的一种方法
 *     重写是子类为了更贴合自己的需求，为自己定做的自己的方法
 *
 *
 *
 */
public class MyTest {
    public static void main(String[] args) {
        /*Dog d1 = new Dog();
        d1.setSex('母');
        d1.setAge(50);
        int age = d1.getAge();
        char sex = d1.getSex();*/
        /*int sum = 0;
        for(int i = 2; i <=100 ; i++){
            String a = "是质数";
            for(int j = 2; j <= i/2; j++){
                if(i%j == 0){
                    a = "不是质数";
                    break;
                }
            }
            if(a == "是质数"){
                sum = sum +i;
            }
        }*/
        /*int n = 0;
        int[] array = {1,2,3,4};
        for(int a:array){
            for(int b: array){
                for(int c: array){
                    if(a==b||a==c||b==c){
                        continue;
                    }else {
                        System.out.println(a*100+b*10+c);
                        n++;
                    }

                }

            }

        }
        System.out.println(n);*/
        Dog d1 = new Dog();
        d1.setSex('公');
        d1.setAge(10);
        d1.setName("nacn");
        d1.run();
        System.out.println(d1.getSex());
        Cat c1 = new Cat();
        c1.run();
    }

}
