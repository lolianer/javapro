package com.neuedu.pojo;

public class Student {
    private Integer sno;
    private String name;
    private String sex;
    private Integer age;

    public Student(Integer sno, String name, String sex, Integer age) {
        this.sno = sno;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public Student(){}
    @Override
    public String toString() {
        return "Student{" +
                "sno=" + sno +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }

    public Integer getSno() {
        return sno;
    }

    public void setSno(Integer sno) {
        this.sno = sno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
