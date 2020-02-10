package com.neuedu.test;

public class SalesEmployee extends ColaEmployee{
    private int sale;
    private double ticheng;
    public SalesEmployee(){}
    public SalesEmployee(String name,int sale,double ticheng){
        super(name);
        this.sale = sale;
        this.ticheng = ticheng;
    }

    @Override
    public double getSalary(int month) {
        return sale*ticheng;
    }
}
