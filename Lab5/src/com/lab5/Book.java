package com.lab5;

import java.util.Map;

public class Book extends Item{

    Book(String id, String name , String location)
    {
        super(id,name,location);
    }

    @Override
    public String toString() {
        return this.getId() + " - " + this.getName();
    }
}
