package com.neuedu.test;

public class SalariedEmployee extends ColaEmployee{

    private double salary;
    public SalariedEmployee(){}
    public SalariedEmployee(String name,int salary){
        super(name);
        this.salary = salary;
    }
    @Override
    public double getSalary(int month) {
        return salary;
    }
}
