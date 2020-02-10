package com.neuedu.test;

public class HourlyEmployee extends ColaEmployee{
    private int hour;
    private double hourlysalary;

    public HourlyEmployee(){}


    public HourlyEmployee(String name,int hour,double hourlysalary){
        super(name);
        this.hour = hour;
        this.hourlysalary = hourlysalary;
    }
    @Override
    public double getSalary(int month) {
        if (hour <= 160){
            return hourlysalary*hour;
        }else {
            return 160*hourlysalary+(hour-160)*1.5*hourlysalary;
        }
    }



}
