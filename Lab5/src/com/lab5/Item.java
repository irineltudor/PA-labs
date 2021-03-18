package com.lab5;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public abstract class Item implements Serializable {
    //Class members
    private String id;
    private String name;
    private String location; //file name or Web page
    private Map<String, Object> tags = new HashMap<>();

    //Class methods

    //Constructor

   Item(String id, String name, String location) {
        this.id=id;
        this.name=name;
        this.location=location;
    }
   //Setters

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setTags(Map<String, Object> tags) {
        this.tags = tags;
    }

    //Getters
   public String getId() {
       return id;
   }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public Map<String, Object> getTags() {
        return tags;
    }
    public void addTag(String key, Object obj) {
        tags.put(key, obj);
    }
    //Function

    @Override
    public String toString() {
        return super.toString();
    }

}
