package com.example;

import java.util.Map;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class DeleteDataFromDB {

    public static Map<String, Object> deleteData(int id, String tableName) {
        
        MYSQLConnector connector = new MYSQLConnector();

        try{
            Connection newConnection = connector.connectToDB();
            Statement statement = newConnection.createStatement();

            String query = String.format("DELETE FROM %s WHERE id = %d", tableName, id);
            statement.executeUpdate(query);

            System.out.println("Record has been deleted successfully");
            Map<String, Object> response = new HashMap<>();

            response.put("message", "Records has been deleted");
            response.put("statusCode", 200);

            return response;
        } catch (SQLException e) {
            e.printStackTrace();
            Map<String, Object> response = new HashMap<>();
            
            response.put("message", "An error occurred");
            response.put("statusCode", 400);

            return response;
        }
    }
}
