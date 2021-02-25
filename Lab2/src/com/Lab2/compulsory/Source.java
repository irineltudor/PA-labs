package com.Lab2.compulsory;

public class Source {
    //Class members

    private String name;
    private SourceType source;
    private int supply;
    //Class methods

    //Constructors
    Source(String name,int type,int supply)
    {
        this.name=name;
        this.supply=supply;
        if(type==1)
        {
            this.source=SourceType.WAREHOUSE;
        }
        else this.source=SourceType.FACTORY;
    }

    //Getters

    public String getName() {
        return name;
    }

    public SourceType getSource() {
        return source;
    }

    public int getSupply() {
        return supply;
    }
    //Setters


    public void setName(String name) {
        this.name = name;
    }

    public void setSource(SourceType source) {
        this.source = source;
    }

    public void setSupply(int supply) {
        this.supply = supply;
    }

    @Override
    public String toString() {
        return this.name + " is a " + this.source + " and has " + this.supply + " commodities";
    }


}
