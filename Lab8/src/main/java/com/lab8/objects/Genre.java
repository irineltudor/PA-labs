package com.lab8.objects;

public class Genre {

    public String name;

    public Genre(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Genre() {

    }

    @Override
    public String toString() {
        return "Numele genului: " + name;
    }
}
