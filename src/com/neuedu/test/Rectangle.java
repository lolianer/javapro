package com.neuedu.test;

public class Rectangle extends Shape {
    private float width;
    private float height;

    public Rectangle(){

    }

    public Rectangle(float width,float height,String  color){
        super(color);
        this.width = width;
        this.height = height;

    }

    @Override
    public float getArea() {
        return width*height;
    }

    @Override
    public float getPer() {
        return 2*(width+height);
    }

    @Override
    public void showAll() {
        System.out.println("矩形的长为："+width);
        System.out.println("矩形的宽为："+height);
        System.out.println("矩形的面积为："+getArea());
        System.out.println("矩形的周长为："+getPer());
        System.out.println("矩形的周长为："+getColor());
    }
}
