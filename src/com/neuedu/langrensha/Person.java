package com.neuedu.langrensha;

public class Person {
    private int no;
    private String pai;

    public String getPai() {
        return pai;
    }

    public Person(int no) {
        this.no = no;
    }

    public void setPai(String pai) {
        this.pai = pai;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }
}
