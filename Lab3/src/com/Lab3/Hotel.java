package com.Lab3;

public class Hotel extends Location implements Payable, Classifiable {

    private String rank;
    private double ticketPrice;

    //Constructors
    Hotel(){}
    Hotel(String name)
    {
        super(name);
    }

    public void setRank(String rank) {
        this.rank=rank;
    }


    @Override
    public String classification() {
        return this.rank;
    }

    @Override
    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}

