package com.example;

import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;

public class Handler {
    public void handleRequest(Map<String, Object> event, Context context) {
        System.out.println(event);
    }
}
