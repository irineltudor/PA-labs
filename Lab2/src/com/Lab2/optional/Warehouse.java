package com.Lab2.optional;

public class Warehouse extends Source {

    //Constructor

    Warehouse(String name, int supply) {
        super(name, supply);

    }

    @Override
    public String toString() {
        return this.getName() + " is a Warehouse and has " + this.getSupply() + " commodities ";
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
}
