package com.neuedu.test;

public abstract class ColaEmployee {
    private String name;
    private int month;
    public ColaEmployee(){}
    public ColaEmployee(String name){
        this.name = name;
    }
    public abstract double getSalary(int month);
}
