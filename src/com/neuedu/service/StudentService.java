package com.neuedu.service;

import com.neuedu.dao.IStudentDao;
import com.neuedu.dao.StudentDao;
import com.neuedu.dao.StudentDao2;
import com.neuedu.pojo.Student;

import java.util.List;

public class StudentService implements IStudentService {
    IStudentDao isd = new StudentDao2();
    @Override
    public List<Student> query() {
        return isd.query();
    }

    @Override
    public int add(Student student) {
        int result = isd.add(student);
        return result;
    }

    @Override
    public int update(Student student) {
        return isd.update(student);
    }

    @Override
    public int delete(int sno) {
        return isd.delete(sno);
    }

    @Override
    public Student queryone(int sno) {
        return isd.queryone(sno);
    }
}
