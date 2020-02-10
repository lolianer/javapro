package com.neuedu.test;

public abstract class Shape {
    private float area;
    private float per;
    private String  color;
    public Shape(){

    }
    public String getColor(){
        return color;
    }
    public Shape(String  color){
        this.color = color;
    }
    public abstract float getArea();
    public abstract float getPer();
    public abstract void showAll();
}
