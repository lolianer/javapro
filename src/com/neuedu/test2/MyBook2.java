package com.neuedu.test2;

import java.io.Serializable;

public class MyBook2 implements Serializable {
    private static final long serialVersionUID = 2L;
    private String name;
    private Double price;
    private String press;
    private String author;
    private String bookISBN;

    public MyBook2(String name, Double price, String press, String author, String bookISBN) {
        this.name = name;
        this.price = price;
        this.press = press;
        this.author = author;
        this.bookISBN = bookISBN;
    }

    @Override
    public String toString() {
        return "MyBook{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", press='" + press + '\'' +
                ", author='" + author + '\'' +
                ", bookISBN='" + bookISBN + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
