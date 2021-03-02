package com.Lab2.compulsory;

public class Source {
    //Class members

   protected String name;
    protected  SourceType source;
    protected  int supply;
    //Class methods

    //Constructors
    Source() { }
    Source(String name,SourceType source,int supply)
    {
        this.name=name;
        this.supply=supply;
        this.source=source;
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
        if(name==null)
            throw new IllegalArgumentException("Name cannot be null");
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
