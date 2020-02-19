package com.neuedu.test;

import com.neuedu.pojo.Student;
import com.neuedu.test2.MyBook;
import com.neuedu.util.JdbcUtil2;
import com.neuedu.web.StudentWeb;

import java.util.List;

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

        /*StudentWeb s = new StudentWeb();
        s.menu();*/
        String sql = "select * from Student";
        String[] a = {"sno","name","sex","age"};
        Object[][] students = JdbcUtil2.query2(sql,a);
        for (int i = 0; i < students.length; i++){
            for (int j = 0; j < a.length; j++){
                System.out.println(students[i][j]);
            }
        }

            



    }
}
