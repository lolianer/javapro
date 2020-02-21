package com.neuedu.test;

import com.neuedu.pojo.Student;
import com.neuedu.util.JdbcUtil2;
import com.neuedu.web.StudentWeb;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.neuedu.util.JdbcUtil.getConnection;

public class Test {
    public static void main(String[] args) {
        /*Shape r1 = new Rectangle(10,10,"红色");
        r1.showAll();
        Shape r2 = new Circle(10,"绿色");
        r2.showAll();*/




        /*SalariedEmployee salariedEmployee = new SalariedEmployee("张三",5000);
        System.out.println("固定工资为："+salariedEmployee.getSalary(5));
        HourlyEmployee hourlyEmployee = new HourlyEmployee("李四",50,60);
        System.out.println("小时工资为："+hourlyEmployee.getSalary(5));
        SalesEmployee salesEmployee = new SalesEmployee("王五",100000,0.05);
        System.out.println("提成工资为："+salesEmployee.getSalary(5));*/
        /*MainBoard mainBoard = new MainBoard();
        I3 i3 = new I3();
        mainBoard.setCpu(i3);
        mainBoard.method();*/

        StudentWeb s = new StudentWeb();
        s.menu();
        String sql = "select * from Student";
        String[] a = {"sno","name","sex","age"};
        Object[][] students = JdbcUtil2.query2(sql,a);
        for (int i = 0; i < students.length; i++){
            for (int j = 0; j < a.length; j++){
                System.out.println(students[i][j]);
            }
        }
        /*ExecutorService service = Executors.newCachedThreadPool();
        service.execute(()->{
            shiwu1();
        });
        service.execute(()->{
            shiwu2();
        });*/


            



    }
    public static void shiwu1() {
        Student student = new Student();
        int result = 0;
        Connection con = getConnection();
        PreparedStatement pstmt = null;
        try {
            con.setAutoCommit(false);
            String sql = "insert into Student(sno,name,sex,age) values (15,'安防','男',20)";
            pstmt = con.prepareStatement(sql);
            //执行语句
            result = pstmt.executeUpdate();
            System.out.println(result);
            Thread.sleep(3000);
            int a = 100/0;
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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
    public static  void shiwu2(){
        Connection con = getConnection();
        List<Student> students = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con.setAutoCommit(false);
            con.setTransactionIsolation(1);
            Thread.sleep(1000);
            String sql = "select * from Student";
            pstmt = con.prepareStatement(sql);

            rs = pstmt.executeQuery();
            while(rs.next()){
                Student student = new Student();
                student.setSno(rs.getInt("sno"));
                student.setName(rs.getString("name"));
                student.setSex(rs.getString("sex"));
                student.setAge(rs.getInt("age"));
                students.add(student);

                con.commit();
            }
        }  catch (SQLException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (pstmt != null)
                    pstmt.close();
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println(students);
    }
}
