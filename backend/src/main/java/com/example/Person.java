package com.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Person {
    private int id;
    private String name;

    public Person(String json) {
        Gson gson = new Gson();
        Person request = gson.fromJson(json, Person.class);

        this.name = request.getName();
        this.id = request.getId();
    }

    public void setName(String name) {
        this.name = name;
    } 

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }

}
