package com.lab5;

import java.util.Map;

public class Book extends Item{
    private String releaseYear;
    Book(String id, String name , String location,String releaseYear) throws InvalidYearException {
        super(id,name,location);
        if(Integer.parseInt(releaseYear) < 1000 || Integer.parseInt(releaseYear) > 2021)
        {
            throw new InvalidYearException(name);
        }
        else{
            this.releaseYear=releaseYear;
        }

    }

    @Override
    public String toString() {
        return this.getId() + " - " + this.getName();
    }
}
