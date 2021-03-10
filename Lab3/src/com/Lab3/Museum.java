package com.Lab3;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.List;

public class Museum extends Location implements Visitable,Payable{
    private LocalTime openingTime, closingTime;
    private double ticketPrice;

    //Constructor
    Museum(){}
    Museum(String name)
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
    @Override
    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}
