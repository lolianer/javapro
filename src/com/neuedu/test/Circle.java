package com.neuedu.test;

public class Circle extends Shape {
    private float radius;

    public Circle(){

    }
    public Circle(float radius,String color){
        super(color);
        this.radius = radius;

    }

    @Override
    public float getPer() {
        float per = 2*3.14f*radius;
        return per;
    }

    @Override
    public float getArea() {
        return 3.14f*radius*radius;
    }

    @Override
    public void showAll() {
        System.out.println("圆的半径为："+radius);
        System.out.println("圆的面积为："+getArea());
        System.out.println("圆的周长为："+getPer());
    }
}
