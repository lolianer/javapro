package com.neuedu.dao;

import com.neuedu.pojo.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao implements IStudentDao{
    private String url = "jdbc:mysql://192.168.10.155:3306/db1?useUnicode=true&characterEncoding=utf8";
    private String username = "root";
    private String password = "123456";
    List<Student> students = new ArrayList<>();
    @Override
    public List<Student> query() {
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url,username,password);
            String sql = "select * from Student";
            pstmt = connection.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next()){
                Student student = new Student();
                student.setSno(rs.getInt("Sno"));
                student.setName(rs.getString("Sname"));
                student.setSex(rs.getString("Ssex"));
                student.setAge(rs.getInt("Sage"));
                students.add(student);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (rs != null)
                    rs.close();
                if (pstmt != null)
                    pstmt.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return students;
    }

    @Override
    public int add(Student student) {
        int result = 0;
        Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //建立连接
            connection = DriverManager.getConnection(url,username,password);
            //写mysql语句
            String sql = "insert into Student(Sno,Sname,Ssex,Sage) values (?,?,?,?)";
            pstmt = connection.prepareStatement(sql);
            //设置问号的值
            pstmt.setInt(1,student.getSno());
            pstmt.setString(2,student.getName());
            pstmt.setString(3,student.getSex());
            pstmt.setInt(4,student.getAge());
            //执行语句
            result = pstmt.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (pstmt != null)
                    pstmt.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public int update(Student student) {
        int result = 0;
        Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            //调用驱动
            Class.forName("com.mysql.jdbc.Driver");
            //连接数据库
            connection = DriverManager.getConnection(url,username,password);
            //写语句
            String sql = "update Student set Sname=?, Ssex=?, Sage=? where Sno=?";
            pstmt = connection.prepareStatement(sql);
            //设置问号
            pstmt.setString(1,student.getName());
            pstmt.setString(2,student.getSex());
            pstmt.setInt(3,student.getAge());
            pstmt.setInt(4,student.getSno());
            //执行语句
            result = pstmt.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (pstmt != null)
                    pstmt.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public int delete(int sno) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        int result = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url,username,password);
            String sql = "delete from Student where Sno=?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1,sno);
            result = pstmt.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (pstmt != null)
                    pstmt.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public Student queryone(int sno) {
        Connection c = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Student student = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection(url,username,password);
            String sql = "select * from Student where Sno=?";
            pstmt = c.prepareStatement(sql);
            pstmt.setInt(1,sno);
            rs = pstmt.executeQuery();
            rs.next();
            student = new Student();
            student.setSno(rs.getInt("Sno"));
            student.setName(rs.getString("Sname"));
            student.setSex(rs.getString("Ssex"));
            student.setAge(rs.getInt("Sage"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (rs != null)
                    rs.close();
                if (pstmt != null)
                    pstmt.close();
                if (c != null)
                    c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return student;
    }
}
