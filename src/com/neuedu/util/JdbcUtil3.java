package com.neuedu.util;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcUtil3 {
    private static final String URL = "jdbc:mysql://192.168.10.155:3306/db1?useUnicode=true&characterEncoding=utf8";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        Connection con = null;
        try {
            con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
    public static <T> List<T> query(String sql,Class<T> a, Object... b){
        List<T> list = new ArrayList<>();
        Connection con = getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(sql);
            if (b != null){
                for (int i = 0; i < b.length; i++){
                    pstmt.setObject(i+1,b[i]);
                }
            }
            T t = a.newInstance();
            Field[] field = a.getDeclaredFields();
            rs = pstmt.executeQuery();
            while (rs.next()){
                for (Field f : field){
                    f.setAccessible(true);
                    f.set(t,rs.getObject(f.getName()));
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
    public static int update(String sql,Object... b){
        Connection con = getConnection();
        PreparedStatement pstmt = null;
        int result = 0;
        try {
            pstmt = con.prepareStatement(sql);
            if (b != null){
                for (int i = 0; i < b.length; i++){
                    pstmt.setObject(i+1,b[i]);
                }
            }
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    public static void close(Connection con,PreparedStatement pstmt){
        try {
            if (pstmt != null)
                pstmt.close();
            if (con != null)
                con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void close(Connection con,PreparedStatement pstmt,ResultSet rs){
        try {
            if (rs != null)
                rs.close();
            close(con,pstmt);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
