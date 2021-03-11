package com.Lab4;

public class School implements Comparable<School>{
    private String name;

    //Constructor
    School(){}
    School(String name)
    {
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int compareTo(School anotherSchool) {
        return this.name.compareTo(anotherSchool.getName());
    }
}
