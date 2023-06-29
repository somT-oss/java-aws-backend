package com.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class InsertDataIntoDB {

    public Map<String, Object> WriteToDatabase(String tableName, String username, String email, String password) {
        
        Map<String, Object> response = new HashMap<>();
        DatabaseConnector connector = new DatabaseConnector();

        try {
            Connection connection = connector.connectToDB();
            String insert = String.format("INSERT INTO %s (id, username, email, password) VALUES (1, '%s', '%s', '%s')", tableName, username, email, password);
            
            System.out.println(insert);
            Statement statement = connection.createStatement();  
            
            statement.executeUpdate(insert);
            

            response.put("message", "User information successfully added");
            response.put("statuCode", 200);

            return response;

        } catch (SQLException e) {
            e.printStackTrace();

            response.put("message", "An error occurred");
            response.put("statuCode", 400);

            return response;
        }
    }
}
