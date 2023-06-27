package com.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertDataIntoDB {

    public static String createNewTable(String tableName) {
        MYSQLConnector connector = new MYSQLConnector();

        try {
            Connection newConnection =  connector.connectToDB();
            Statement statement = newConnection.createStatement();
            
            String insert = String.format("CREATE TABLE %s (id INTEGER, username STRING UNIQUE, email STRING, password STRING)", tableName);
            System.out.println(insert);

            statement.executeUpdate(insert);
            return "Created new table";
        } catch (Exception e) {
            return "Table already exists";
        }
    }

    public static String WTDB(String tableName, String username, String email, String password) {
        
        MYSQLConnector connector = new MYSQLConnector();

        try {
            Connection newConnection = connector.connectToDB();
            String insert = String.format("INSERT INTO %s values(1, '%s', '%s', '%s')", tableName, username, email, password);
            
            System.out.println(insert);
            Statement statement = newConnection.createStatement();  
            
            statement.executeUpdate(insert);
            return "Records updated";
        } catch (SQLException e) {
    
            return "An error occurred";
        }
    }
}
