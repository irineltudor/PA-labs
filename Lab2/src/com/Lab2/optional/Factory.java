package com.Lab2.optional;

public class Factory extends Source {

    Factory(String name, int supply) {
        super(name, supply);

    }

    @Override
    public String toString() {
        return this.getName() + " is a Factory and has " + this.getSupply() + " commodities ";
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

}
