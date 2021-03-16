package com.Lab4;

import java.util.Random;

public class Student {
    //Class members
    private String name;
    private int score;
    //Class methods

    //Constructor

    Student() {
    }

    Student(String name) {
        this.name = name;
        Random random = new Random();
        this.score=random.nextInt(10 - 5 + 1) + 1;
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    //Getters
    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}
