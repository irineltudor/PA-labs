package com.Lab3;

import java.time.LocalTime;
import java.util.HashMap;

public class Church extends Location implements Visitable {
    HashMap<String,Integer> hm = new HashMap< String,Integer>();
    private LocalTime openingTime, closingTime;
    //Constructor
    Church(){}
    Church(String name)
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

}
