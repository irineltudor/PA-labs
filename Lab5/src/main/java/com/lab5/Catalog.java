package com.lab5;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {
   //Class members
    private String name;
    private String path;
    private List<Item> items = new ArrayList<>();
    //Class methods
    //Constructor
    Catalog(String name, String path) {
        this.name = name;
        this.path = path;
    }

    Catalog() {

    }

    //Getters
    public String getName() {
        return name;
    }

    public List<Item> getItems() {

        return items;
    }
    public String getPath() {
        return path;
    }
    //Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }


   //Functions
    public void list()
    {
        System.out.println(this.name);
        System.out.println(this.items);

    }

    public void add(Item item) {
        items.add(item);
    }

    public Item findById(String id) {
        return items.stream()
                .filter(d -> d.getId().equals(id)).findFirst().orElse(null);
    }



    @Override
    public String toString() {
        return "Catalog{" +
                "name='" + name + '\'' +
                ", items=" + items +
                '}';
    }
}

