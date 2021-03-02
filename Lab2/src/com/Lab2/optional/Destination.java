package com.Lab2.optional;

import java.util.Objects;

public class Destination {
    //Class members

    private String name;
    private int demand;

    //Class methods

    //Constructors
    Destination(){}
    Destination(String name, int demand)
    {
        this.name=name;
        this.demand=demand;
    }

    //Getters

    public String getName() {
        return name;
    }

    public int getDemand() {
        return demand;
    }
    //Setters

    public void setName(String name) {
        if(name==null)
            throw new IllegalArgumentException("Name cannot be null");
        this.name = name;
    }

    public void setDemand(int demand) {
        this.demand = demand;
    }

    @Override
    public String toString() {
        return "Destination's name is " + name +  " and needs " + this.demand + " commodities ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Destination that = (Destination) o;
        return demand == that.demand && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, demand);
    }
}
