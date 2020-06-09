package com.demo.test12;

import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Iterator;

public class jdbcDemo extends Thread{


     final int a = 5;
     public void main(){


     }
    public static void main (String[] args){

         //long lo = 11.22;

         Connection conn = null;
         PreparedStatement pres = null;
         ResultSet res = null;
         try {
         Class.forName("com.mysql.jdbc.Driver");//com.mysql.jdbc.Driver
         String url = "jdbc:mysql://127.0.0.1:3306/test";
         String user = "root";
         String passw = "123456";
         conn = DriverManager.getConnection(url, user, passw);

         String sql = "select name,cno from student2 where name = ? ";
         PreparedStatement preparedStatement = conn.prepareStatement(sql);
         preparedStatement.setObject(1,"s1");
         ResultSet resultSet = preparedStatement.executeQuery();

         while (resultSet.next()){
             System.out.println(resultSet.getObject(1));
         }


         }catch (Exception e){
         e.printStackTrace();
         }finally {

         try {

         res.close();
         pres.close();
         conn.close();
         }catch (Exception e){
         e.printStackTrace();
         }


         }



    }
}
