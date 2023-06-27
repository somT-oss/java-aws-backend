package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class MYSQLConnector {
    
    final String DATABASE_NAME = "users";
    
    public Connection connectToDB(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(String.format("jdbc:sqlite:%s.db", DATABASE_NAME));
        } catch (SQLException error) {
            System.err.println(error.getMessage());
        }
        return connection;
    }
}

