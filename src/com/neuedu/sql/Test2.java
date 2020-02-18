package com.neuedu.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test2 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://192.168.10.155:3306/db1?useUnicode=true&characterEncoding=utf8";
        String username = "root";
        String password = "123456";
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url,username,password);
            pstmt = con.prepareStatement("insert into Student(Sno,Sname,Ssex,Sage) values(003,'申伟中','男',20)");
            int i = pstmt.executeUpdate();
            System.out.println(i);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (pstmt != null)
                    pstmt.close();
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
