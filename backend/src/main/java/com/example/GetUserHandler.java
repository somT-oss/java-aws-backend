package com.example;

import java.util.HashMap;
import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;

public class GetUserHandler {

    public void handlerRequest(Map<String, Object> event, Context context) {
        GetDataFromDB getData = new GetDataFromDB();
        
        Map<String, Object> response = new HashMap<>();
        Map<String, Object> user = getData.getData(1, "users");

        if (user.get("statusCode").equals(200)) {
            response.put("id", user.get("id"));
            response.put("userame", user.get("username"));
            response.put("email", user.get("email"));
            response.put("statusCode", 200);

            System.out.println(response);
        }   

        response.put("message", "An error occurred");
        response.put("statusCode", 400);

        System.out.println(response);
        System.out.println(event);


    }
    
}
