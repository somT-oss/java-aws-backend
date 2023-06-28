package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MYSQLConnector {

    static String HOST = System.getenv("RDS_HOST");
    static String USERNAME = System.getenv("RDS_USERNAME");
    static String PASSWORD = System.getenv("RDS_PASSWORD");
    static String PORT = System.getenv("RDS_PORT");
    static String DATABASE = System.getenv("RDS_DATABASE");
    
    public Connection connectToDB(){

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(String.format("jdbc:postgresql://%s:%s/%s?user=%s&password=%s", HOST, PORT, DATABASE, USERNAME, PASSWORD));
        } catch (SQLException error) {
            System.err.println(error.getMessage());
        }
        return connection;
    }

}

