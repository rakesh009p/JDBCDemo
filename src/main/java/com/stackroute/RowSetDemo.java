package com.stackroute;

import java.sql.*;

public class RowSetDemo {
    public void rows(){
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");} catch (ClassNotFoundException e) {
        e.printStackTrace();

    }
        try (  Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","");
    Statement statement=connection.createStatement();

    ResultSet resultSet=  statement.executeQuery("select name,age,gender from user where gender='male'");){
//                Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","P@ssw0rd");
//                Statement statement=connection.createStatement();
//             ResultSet resultSet=  statement.executeQuery("select * from user");

        while(resultSet.next()){
            System.out.print(resultSet.getString("name"));
            System.out.print(" "+resultSet.getString("age"));
            System.out.println(" "+resultSet.getString("gender"));
        }
     } catch (
    SQLException ex) {
        ex.printStackTrace();
    }}
}
