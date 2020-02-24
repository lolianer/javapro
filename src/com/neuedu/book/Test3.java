package com.neuedu.book;

import com.neuedu.util.JdbcUtil2;
import com.neuedu.util.JdbcUtil3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test3 {
    public static List<MyBook2> books = new ArrayList<>(200);
    public static File file = new File("e:/tushu");
    public static void main(String[] args) {
        load();
        print(books);
    }
    public static void initData(List<MyBook2> books){
        for (int i = 0; i < 30; i++){
            MyBook2 myBook = new MyBook2("名字",12.5,"自己","我","asds"+i);
            books.add(myBook);
        }
    }
    public static void inputData(List<MyBook2> books){
        System.out.println("请输入要输入的个数");
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for (int i = 0; i < n; i++){
            System.out.println("第"+(i+1)+"本书的信息");
            System.out.println("书名");
            String name = s.next();
            System.out.println("价格");
            Double price = s.nextDouble();
            System.out.println("出版社");
            String press = s.next();
            System.out.println("作者");
            String author = s.next();
            System.out.println("ISBN");
            String ISBN = s.next();
            MyBook2 myBook = new MyBook2(name,price,press,author,ISBN);
            books.add(myBook);
        }
    }
    public static void print(List<MyBook2> books){
        for (MyBook2 book : books){
            System.out.println(book);
        }
    }
    public static void searchName(List<MyBook2> books, String name){
        for (MyBook2 book : books){
            if (book.getName().equals(name)){
                System.out.println(book);
                return;
            }
        }
        System.out.println("查无此书");
    }
    public static void deleteName(List<MyBook2> books, String name){
        for (int i = 0; i< books.size();i++){
            if (books.get(i).getName().equals(name)){
                books.remove(i);
                System.out.println("删除成功");
                return;
            }
        }
        System.out.println("查无此书");
    }
    public static void menu(){
        int flag = 0;
        while (flag == 0){
            System.out.println("请选择你要进行的操作（请输入1-4中的任一个数字）");
            System.out.println("1：添加图书");
            System.out.println("2：全部查看");
            System.out.println("3：查找图书");
            System.out.println("4：删除图书");
            System.out.println("其他：退出");
            Scanner s = new Scanner(System.in);
            int a = 0 ;
            try{
                a = s.nextInt();
            }catch (Exception ex){
                System.out.println("输入错误，请重新输入");
                a = s.nextInt();
            }
            if (a == 1){
                inputData(books);
                save();
            }else if (a == 2){
                print(books);
            }else if (a == 3){
                System.out.println("请输入要查找的图书");
                String name = s.next();
                searchName(books,name);
            }else if (a == 4){
                System.out.println("请输入要删除的图书");
                String name = s.next();
                deleteName(books,name);
                save();
            }else {
                flag = 1;
            }
        }
    }
    public static void save(){
        String sql = "insert into book(name,price,press,author,bookISBN) values(?,?,?,?,?)";
        for (int i = 0; i < books.size(); i++){
            MyBook2 book2 = books.get(i);
            Object[] object = {book2.getName(),book2.getPrice(),book2.getPress(),book2.getAuthor(),book2.getBookISBN()};
            JdbcUtil3.update(sql,object);
        }

    }
    public static void load(){
        String sql = "select * from book";


    }

}
