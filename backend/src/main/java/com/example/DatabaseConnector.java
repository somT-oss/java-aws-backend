package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.amazonaws.services.simplesystemsmanagement;


public class DatabaseConnector {

    
    String HOST = StringParameter.valueForStringParameter(t, "RDS_HOST");
    String USERNAME = StringParameter.valueForStringParameter(null, "RDS_USERNAME");
    String PASSWORD = StringParameter.valueForStringParameter(null, "RDS_PASSWORD");
    String PORT = StringParameter.valueForStringParameter(null, "RDS_PORT");
    String DATABASE = StringParameter.valueForStringParameter(null, "RDS-DATABASE");
    
    public  Connection connectToDB(){
        
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(String.format("jdbc:postgresql://%s:%s/%s?user=%s&password=%s", HOST, PORT, DATABASE, USERNAME, PASSWORD));
        } catch (SQLException error) {
            System.err.println(error.getMessage());
        }
        return connection;
    }

}

