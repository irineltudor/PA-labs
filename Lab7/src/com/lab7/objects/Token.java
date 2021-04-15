package com.lab7.objects;

import java.util.Random;

public class Token {
    protected int a;
    protected int b;
    protected int cost;

    public Token()
    {

    }
    public Token(int size)
    {
        Random random=new Random();
        this.a= random.nextInt(size + 1 - 1) + 1;
        this.b=random.nextInt(size + 1 - 1) + 1;
        this.cost=random.nextInt(size + 1 - 1) + 1;
    }

    public Token(int i, int i1, int i2) {
        this.a=i;
        this.b=i1;
        this.cost=i2;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }


    @Override
    public String toString() {
        return "Token{" +
                "a=" + a +
                ", b=" + b +
                ", cost=" + cost +
                '}';
    }
}
