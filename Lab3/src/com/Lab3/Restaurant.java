package com.Lab3;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Restaurant extends Location implements Visitable,Classifiable{
    HashMap<String,Integer> hm = new HashMap< String,Integer>();
    private LocalTime openingTime, closingTime;
    private String rank;

    //Constructor
    Restaurant(){}
    Restaurant(String name)
    {
        super(name);
    }

    @Override
    public LocalTime getOpeningTime() {
        return openingTime;
    }
    public void setOpeningTime(LocalTime openingTime) {
        this.openingTime = openingTime;
    }
    @Override
    public LocalTime getClosingTime() {
        return closingTime;
    }
    public void setClosingTime(LocalTime closingTime) {
        this.closingTime = closingTime;
    }

    public void setRank(String rank) {
        this.rank=rank;
    }


    @Override
    public String classification() {
        return this.rank;
    }
}
