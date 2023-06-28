package com.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertDataIntoDB {

    public static String createNewTable(String tableName) {
        
        NewDatabaseConnector connector = new NewDatabaseConnector();
        Connection connection =  connector.newConnector();
        
        if (connection != null) {
          try {
            
                Statement statement = connection.createStatement();
                String insert = String.format("CREATE TABLE %s (id INTEGER, username TEXT, email TEXT, password TEXT)", tableName);

                statement.executeUpdate(insert);
                return "Created new table";
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }     
        } 
        return null;
        
    }

    public static String WTDB(String tableName, String username, String email, String password) {
        
        NewDatabaseConnector connector = new NewDatabaseConnector();

        try {
            Connection connection = connector.newConnector();
            String insert = String.format("INSERT INTO %s (id, username, email, password) VALUES (1, '%s', '%s', '%s')", tableName, username, email, password);
            
            System.out.println(insert);
            Statement statement = connection.createStatement();  
            
            statement.executeUpdate(insert);
            return "Records updated";
        } catch (SQLException e) {
            e.printStackTrace();
            return "An error occurred";
        }
    }

    public static void main(String[] args) {
        // String createNewTable = createNewTable("persons");

        String writeToDb = WTDB("persons", "somto", "somtogmail.com", "testing321");

        // System.out.println(createNewTable);
        System.out.println(writeToDb);
    }
}
