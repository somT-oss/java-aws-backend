package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MYSQLConnector {

    static String USERNAME = "postgres";
    static String PASSWORD = "testing321";
    static String HOSTNAME = "database.cjrtmsmvxnfm.us-east-1.rds.amazonaws.com";
    static String PORT = "5432";
    
    public Connection connectToDB(){

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(String.format("jdbc:postgresql://%s:%s/?user=%s&password=%s", HOSTNAME, PORT, USERNAME, PASSWORD));
        } catch (SQLException error) {
            System.err.println(error.getMessage());
        }
        return connection;
    }

}

