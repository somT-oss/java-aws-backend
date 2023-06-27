package com.example;

import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.InsertOneResult;

import org.bson.types.ObjectId;
import org.bson.Document;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WriteToDb {

    public static String WTDB() {
        MongoConnector connector = new MongoConnector();
        MongoDatabase db = connector.connector();
        System.out.println(db.getName());
        Logger logger = LoggerFactory.getLogger(WriteToDb.class);

        try {
            MongoCollection<Document> usersCollection = db.getCollection("users-collection");
            
            logger.info("Creating new document object");
            Document document = new Document("_id", new ObjectId()).append("username", "Somto");
            logger.info("Created new document object");

            InsertOneResult result = usersCollection.insertOne(document);
            System.out.println(result);
            return "Document uploaded successfully";

        } catch (MongoException e) {
            e.printStackTrace();
            return "An error occurred";

        }
    }

    public static void main(String[] args) {
        String write = WTDB();
        System.out.println(write);
    }
}
