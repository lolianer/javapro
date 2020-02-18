package com.neuedu.dao;

import com.neuedu.pojo.Student;

import java.util.List;

public interface IStudentDao {
    List<Student> query();
    int add(Student student);
    int update(Student student);
    int delete(int sno);
    Student queryone(int sno);
}
