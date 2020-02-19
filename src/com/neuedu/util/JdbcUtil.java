package com.neuedu.util;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcUtil {
    private static final String URL = "jdbc:mysql://192.168.10.155:3306/db1?useUnicode=true&characterEncoding=utf8";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";
    //加载驱动
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //创建连接
    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    //写sql语句
    public static int executeUpdate(String sql,Object... params){
        PreparedStatement pstmt = null;
        Connection con = getConnection();
        int result = 0;
        try {
            pstmt = con.prepareStatement(sql);
            if (params != null){
                for (int i = 0;i < params.length; i++)
                    pstmt.setObject(i+1,params[i]);
            }
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(con,pstmt);
        }
        return result;
    }
    public static <T> List<T> query(String sql,Class<T> clz,Object... params){
        List<T> list = new ArrayList<>();
        Connection con = getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(sql);
            if (params != null){
                for (int i = 0; i < params.length; i++){
                    pstmt.setObject(i+1,params[i]);
                }
            }
            rs = pstmt.executeQuery();
            while (rs.next()){
                //创建一个T类型的对象
                //该方法通过反射class对象 调用无参构造来创建对象
                T t = clz.newInstance();
                //通过字段名从rs中拿值 然后赋值给对象的属性
                Field[] field = clz.getDeclaredFields();
                for (Field f : field){
                    Object value = rs.getObject(f.getName());
                    //f是一个类的属性，在这里作为一个对象，调用set，为t这个对象，在f这个属性上赋value这个值
                    f.setAccessible(true);

                    f.set(t,value);
                }

                list.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }finally {
            close(con,pstmt,rs);
        }
        return list;
    }
    public static void close(Connection c,PreparedStatement p){
        try {
            if (p != null)
                p.close();
            if (c != null)
                c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void close(Connection c, PreparedStatement p, ResultSet r){
        try {
            if (r != null)
                r.close();
            close(c,p);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
