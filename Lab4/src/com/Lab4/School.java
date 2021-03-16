package com.Lab4;

public class School implements Comparable<School> {
    //Class members
    private String name;
    private int capacity;


    //Class methods

    //Constructor
    School() {
    }

    School(String name) {
        this.name = name;
    }

    School(String name,int capacity){
    this.name=name;
    this.capacity=capacity;}

    //Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    //Getters
    public String getName() {
        return name;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public int compareTo(School anotherSchool) {
        return this.name.compareTo(anotherSchool.getName());
    }
}
