package com.example;


import java.util.HashMap;
import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;



public class CreateUserHandler {

    public void handleRequest(Map<String, Object> event, Context context) {
        
        Map<String, Object> response = new HashMap<>();

        InsertDataIntoDB insert = new InsertDataIntoDB();
        Map<String, Object> handlerCall = insert.WriteToDatabase("users", "john", "johndoegmail.com", "testing321");
        
        if (handlerCall.get("statusCode").equals(200)) {
            
            
            response.put("message", "An error occurred");
            response.put("statusCode", 400);

            System.out.println(response);
        }

        response.put("message", "Records successfully updated");
        response.put("statusCode", 400);

        System.out.println(response);
        System.out.println(event);
        
    }
}
