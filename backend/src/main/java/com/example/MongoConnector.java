package com.example;

import org.bson.Document;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;





public class MongoConnector {

    final static String MONGO_USERNAME = System.getenv("MONGO_USERNAME");
    final static String MONGO_PASSWORD = System.getenv("MONGO_PASSWORD");

    public static String check() {
        String connectionString = String.format("mongodb+srv://%s:%s@microservice-cluster.yprquhy.mongodb.net/?retryWrites=true&w=majority", MONGO_USERNAME, MONGO_PASSWORD);
        ServerApi serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(connectionString))
                .serverApi(serverApi)
                .build();
        // Create a new client and connect to the server
        try (MongoClient mongoClient = MongoClients.create(settings)) {
            try {
                // Send a ping to confirm a successful connection
                MongoDatabase database = mongoClient.getDatabase("admin");
                database.runCommand(new Document("ping", 1));
                return "Connected";
            } catch (MongoException e) {
                e.printStackTrace();
                return "Not connected";
            }
        }

    }

    public static void main(String[] args) throws Exception {
                String check = check();
                System.out.println(check);
            }
}

