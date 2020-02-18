package com.neuedu.web;

import com.neuedu.pojo.Student;
import com.neuedu.service.IStudentService;
import com.neuedu.service.StudentService;

import java.util.List;
import java.util.Scanner;

public class StudentWeb {
    IStudentService iss = new StudentService();
    public void menu(){
        System.out.println("请输入以下选项");
        System.out.println("1-----展示所有");
        System.out.println("2--------添加");
        System.out.println("3--------修改");
        System.out.println("4--------删除");
        System.out.println("5--------查找");
        System.out.println("其他------退出");
        System.out.println("------------");
        input();
    }
    public void input(){
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        if (a == 1){
            query();
        }else if (a == 2){
            add();
        }else if (a == 3){
            update();
        }else if (a == 4){
            delete();
        }else if (a == 5){
            queryone(s);
        }else {
            System.exit(0);
        }
    }
    public void query(){
        List<Student> students = iss.query();
        for (Student student : students)
            System.out.println(student);
    }
    public void add(){
        Scanner s = new Scanner(System.in);
        System.out.println("请输入要添加的内容");
        System.out.println("序号");
        int a = s.nextInt();
        System.out.println("名字");
        String name = s.next();
        System.out.println("性别");
        String sex = s.next();
        System.out.println("年龄");
        int age = s.nextInt();
        Student student = new Student(a,name,sex,age);
        int result = iss.add(student);
        System.out.println(result);
    }
    public void update(){
        Scanner s = new Scanner(System.in);
        System.out.println("请输入要修改的列的序号");
        int no = s.nextInt();
        System.out.println("请输入修改后的名字");
        String name = s.next();
        System.out.println("请输入修改后的性别");
        String sex = s.next();
        System.out.println("请输入修改后的年龄");
        int age = s.nextInt();
        Student student = new Student(no,name,sex,age);
        int result = iss.update(student);
        System.out.println(result);
    }
    public void delete(){
        Scanner s = new Scanner(System.in);
        System.out.println("请输入要删除的序号");
        int no = s.nextInt();
        int result = iss.delete(no);
        System.out.println(result);
    }
    public void queryone(Scanner scanner){
        System.out.println("请输入要查找的序号");
        int no = scanner.nextInt();
        Student student = iss.queryone(no);
        System.out.println(student);
    }
}
