package com.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class GetDataFromDB {

    public static Map<String, Object> getData(int id) {
        MYSQLConnector connector = new MYSQLConnector();
        
        try{
            Connection connection = connector.connectToDB();
            Statement statement = connection.createStatement();

            String query = String.format("SELECT * FROM users WHERE id = %d", id);
            ResultSet result = statement.executeQuery(query);

            while (result.next()) {
                int main_id = result.getInt("id");
                String username = result.getString("username");
                String email = result.getString("email");

                Map<String, Object> response = new HashMap<>();
                response.put("id", main_id);
                response.put("username", username);
                response.put("email", email);
                response.put("statusCode", 200);

                return response;
            } 
        } catch (SQLException e) {
            e.printStackTrace();

            Map<String, Object> response = new HashMap<>();
            response.put("statusCode", 400);
            return response;
        }
        return null;
        


    }
    
}