package com.neuedu.util;
//自己无参考写/背
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcUtil2 {
    private static final String URL = "jdbc:mysql://110.181.92.207:3306/db1?useUnicode=true&characterEncoding=utf8";
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
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public static <T> List<T> query(String sql,Class<T> a,Object... b){
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
            rs = pstmt.executeQuery();
            while (rs.next()){
                T t = a.newInstance();

                Field[] field = a.getDeclaredFields();
                for (Field f : field){
                    Object o = rs.getObject(f.getName());
                    f.setAccessible(true);
                    f.set(t,o);
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
    public static int update(String sql,List a){
        Connection con = getConnection();
        PreparedStatement pstmt = null;
        int result = 0;
        try {
            pstmt = con.prepareStatement(sql);
            if (a != null){
                for (int i = 0; i < a.size(); i++){
                    pstmt.setObject(i+1,a.get(i));
                }
            }
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(con,pstmt);
        }
        return result;
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
    public static void close(Connection c, PreparedStatement p, ResultSet rs){
        try {
            if (rs != null)
                rs.close();
            close(c,p);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //用二维数组做一遍查询
    public static Object[][] query2(String sql,String[] a,Object... b){
        Object[][] objects = new Object[10][4];
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
            rs = pstmt.executeQuery();
            int i = 0;
            while (rs.next()){
                for (int j = 0; j < a.length;j++){
                    Object o = rs.getObject(a[j]);
                    try{
                        objects[i][j] = o;
                    }catch (Exception e){
                        System.out.println(i+"   "+j);
                    }

                }
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(con,pstmt,rs);
        }
        return objects;
    }

}
