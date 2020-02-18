package com.neuedu.service;

import com.neuedu.pojo.Student;

import java.util.List;

public interface IStudentService {
    List<Student> query();
    int add(Student student);
    int update(Student student);
    int delete(int sno);
    Student queryone(int sno);
}
