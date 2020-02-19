package com.neuedu.dao;

import com.neuedu.pojo.Student;
import com.neuedu.util.JdbcUtil;
import com.neuedu.util.JdbcUtil2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao2 implements IStudentDao{

    @Override
    public List<Student> query() {
        String sql = "select * from Student";
        List<Student> students = JdbcUtil2.query(sql,Student.class);
        return students;
    }

    @Override
    public int add(Student student) {
        String sql = "insert into Student(sno,name,sex,age) values(?,?,?,?)";
        List list = new ArrayList();
        list.add(student.getSno());
        list.add(student.getName());
        list.add(student.getSex());
        list.add(student.getAge());
        int result = JdbcUtil2.update(sql,list);
        return result;
    }

    @Override
    public int update(Student student) {
        String sql = "update Student set name=?, sex=?, age=? where sno=?";
        Object[] s = {student.getName(),student.getSex(),student.getAge(),student.getSno()};
        int result = JdbcUtil.executeUpdate(sql,s);
        return result;
    }

    @Override
    public int delete(int sno) {
        String sql = "delete from Student where sno=?";
        int result = JdbcUtil.executeUpdate(sql,sno);
        return result;
    }

    @Override
    public Student queryone(int sno) {
        String sql = "select * from Student where sno=?";
        Object s = sno;
        List<Student> students = JdbcUtil.query(sql,Student.class,s);
        Student student = students.get(0);
        return student;
    }
}
