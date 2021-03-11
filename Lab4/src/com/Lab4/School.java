package com.Lab4;

public class School implements Comparable<School> {
    //Class members
    private String name;


    //Class methods

    //Constructor
    School() {
    }

    School(String name) {
        this.name = name;
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }

    //Getters
    public String getName() {
        return name;
    }

    public int compareTo(School anotherSchool) {
        return this.name.compareTo(anotherSchool.getName());
    }
}
