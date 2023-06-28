package com.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class CreateDB {
    
    public String createNewDatabase(String databaseName) {
        
        MYSQLConnector connector = new MYSQLConnector();
        Connection connection = connector.connectToDB();

        if (connection != null ) {
            try {
                Statement statement = connection.createStatement();       
                String insert = String.format("CREATE DATABASE %s", databaseName);
                statement.executeUpdate(insert);

                return "Database created";
            } catch (SQLException e ) {
                e.printStackTrace();
                return null;
            }
        }

        return null;
    }

}
