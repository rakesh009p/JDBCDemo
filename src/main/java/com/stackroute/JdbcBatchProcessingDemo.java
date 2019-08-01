package com.stackroute;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcBatchProcessingDemo {
    public void batchProcessor() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "");
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            statement.addBatch("insert into user values('rak',5,28,'male')");
            statement.addBatch("insert into user values('rakhi',7,29,'male')");
            statement.executeBatch();
            connection.commit();
            connection.close();
        } catch (SQLException E) {
            E.printStackTrace();
        }
    }
}
