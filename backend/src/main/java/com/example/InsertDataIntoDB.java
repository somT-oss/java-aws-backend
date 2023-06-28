package com.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertDataIntoDB {

    public static String WriteToDatabase(String tableName, String username, String email, String password) {
    
        DatabaseConnector connector = new DatabaseConnector();

        try {
            Connection connection = connector.connectToDB();
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
}
