package com.stackroute;

import java.sql.*;

public class JdbcDemo {
    private Statement statement;
    public void displayUser() {


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");} catch (ClassNotFoundException e) {
            e.printStackTrace();

        }
        try (  Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","");
                   Statement statement=connection.createStatement();
                   ResultSet resultSet=  statement.executeQuery("select * from user");){
//                Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","P@ssw0rd");
//                Statement statement=connection.createStatement();
//             ResultSet resultSet=  statement.executeQuery("select * from user");

              while(resultSet.next()){
                  System.out.println(resultSet.getString(1));
              }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
    }
    public void getUserByName(String name){

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","");
            pstmt = con.prepareStatement("select * from user where name = ?");
            pstmt.setString(1,name);
            rs = pstmt.executeQuery();

            while (rs.next()){
                String str1 = rs.getString(1);
                int i = rs.getInt(2);
                String str2 = rs.getString(3);

                System.out.println(str1+" "+i+" "+str2);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        finally {

            try {
                con.close();
                pstmt.close();
                rs.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }
    }

