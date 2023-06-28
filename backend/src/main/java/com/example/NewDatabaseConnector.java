package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class NewDatabaseConnector {
    
    final static String DATABASE_NAME = "person";
    static String USERNAME = "postgres";
    static String PASSWORD = "testing321";
    static String HOSTNAME = "database.cjrtmsmvxnfm.us-east-1.rds.amazonaws.com";
    static String PORT = "5432";

    public Connection newConnector() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(String.format("jdbc:postgresql://%s:%s/%s?user=%s&password=%s", HOSTNAME, PORT, DATABASE_NAME, USERNAME, PASSWORD));
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }   
}
