package com.example;

import java.sql.Connection;

public class EntryPoint {

    public static void main(String[] args) {
        DatabaseConnector connector = new DatabaseConnector();
        Connection conn = connector.connectToDB();
        System.out.println(conn);
    }
}
