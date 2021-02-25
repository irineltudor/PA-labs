package com.Lab2.optional;

import java.util.Objects;

abstract public class Source {
    //Class members

    protected String name;
    protected int supply;
    //Class methods

    //Constructors
    Source(String name, int supply) {
        this.name = name;
        this.supply = supply;

    }

    //Getters

    public String getName() {
        return name;
    }

    public int getSupply() {
        return supply;
    }
    //Setters


    public void setName(String name) {
        this.name = name;
    }

    public void setSupply(int supply) {
        this.supply = supply;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Source source1 = (Source) o;
        return supply == source1.supply && Objects.equals(name, source1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, supply);
    }
}
